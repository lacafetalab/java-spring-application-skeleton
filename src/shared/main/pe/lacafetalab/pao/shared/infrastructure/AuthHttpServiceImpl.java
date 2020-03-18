package pe.lacafetalab.pao.shared.infrastructure;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.exceptions.LclException;

@Component
public class AuthHttpServiceImpl implements AuthHttpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthHttpServiceImpl.class.getName());

	public static final String HEADER_NAME = "Bearer";

	private static final String CHARSET = "UTF-8";
	private static final String CONTENT_TYPE_NAME = "Content-Type";
	private static final String CONTENT_TYPE_VALUE = "application/json";

	private final Gson gson;
	private final HttpClient httpClient;

	public AuthHttpServiceImpl(Gson gson, HttpClient httpClient) {
		this.gson = gson;
		this.httpClient = httpClient;
	}

	@Override
	public <T> void doPost(String url, String token, T body) {
		doPost(url, token, body, String.class);
	}

	@Override
	public <T, S> Optional<S> doPost(String url, String token, T body, Class<S> target) {
		return doRequest(url, "POST", token, body, target).getResponse().getData();
	}

	@Override
	public <S> Optional<S> doGet(String url, String token, Class<S> target) {
		return doRequest(url, "GET", token, null, target).getResponse().getData();
	}

	@Override
	public <T, S> UniversityResponse<S> doRequest(String url, String httpMethod, String token, T body, Class<S> target) {
		Map<String, String> headers = token != null ? Map.of("Authorization", HEADER_NAME + " " + token, CONTENT_TYPE_NAME, CONTENT_TYPE_VALUE) : Map.of(CONTENT_TYPE_NAME, CONTENT_TYPE_VALUE);
		return doRequest(url, httpMethod, headers, body, target);
	}

	@Override
	public <T, S> UniversityResponse<S> doRequest(String url, String httpMethod, Map<String, String> headers, T body, Class<S> target) {
		LOGGER.info("http service request payload [{}]", body != null ? body.toString() : null);
		byte[] bytes = null;
		if (body != null) {
			try {
				String payload = gson.toJson(body);
				bytes = payload.getBytes(CHARSET);
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
				throw new BadRequestException(String.format("Error in external service [%s]", ex.getMessage()));
			}
		}
		return doRequest(url, httpMethod, headers, bytes, target, null);
	}

	@Override
	public <T, S> UniversityResponse<S> doRequest(String url, String httpMethod, Map<String, String> headers, byte[] bytes, Class<S> target, Long timeout) {
		try {
			HttpRequest.Builder HttpRequestBuilder = HttpRequest.newBuilder();

			HttpRequestBuilder.uri(URI.create(url));
			if (timeout != null) {
				HttpRequestBuilder.timeout(Duration.ofMillis(timeout));
			}
			if (headers != null) {
				headers.keySet().stream().forEach(k -> HttpRequestBuilder.header(k, headers.get(k)));
			}
			if (bytes != null) {
				HttpRequestBuilder.method(httpMethod, BodyPublishers.ofByteArray(bytes));
			}

			LOGGER.info("http service request url [{}]", url);
			long start = System.currentTimeMillis();

			HttpResponse<String> response = httpClient.send(HttpRequestBuilder.build(), BodyHandlers.ofString());

			LOGGER.info("http service response done in {} milliseconds  status code [{}] - headers [{}]", (System.currentTimeMillis() - start), response.statusCode(), gson.toJson(response.headers()));

			String content = response.body();

			LOGGER.info("http service response content [{}]", content);
			int responseCode = response.statusCode();

			if (responseCode >= 200 && responseCode < 300) {
				UniversityResponse<S> uresponse = new UniversityResponse<>();
				uresponse.setHeaders(getHeaders(response));
				if (target != null) {
					uresponse.setResponse(getResponse(content, target));
				}
				return uresponse;
			} else if (responseCode < 500) {
				LOGGER.trace("Bad request error {} - university response [{}]", responseCode, content);
				UniversityInternalResponse<Object> error = getResponse(content, Object.class);
				throw new LclException(responseCode, responseCode, error.getMessage(), new Object());
			} else {
				LOGGER.trace("Error {} - auth response [{}]", responseCode, content);
				Object error;
				String message;
				try {
					error = target != null ? getResponse(content, Object.class) : content;
					message = "Error";
					throw new LclException(responseCode, message, error);
				} catch (Throwable e) {
					error = new Object();
					message = "Wrong external service response: [" + content + "]";
					throw new LclException(responseCode, message, error, e);
				}
			}
		} catch (LclException ex) {
			throw ex;
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new BadRequestException(String.format("Error in external service [%s]", ex.getMessage()));
		}
	}

	@Override
	public <T> CompletableFuture<HttpResponse<String>> doRequestAsync(String url, String httpMethod, String token, T body) {

		try {
			HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).authenticator(Authenticator.getDefault()).build();

			HttpRequest.Builder HttpRequestBuilder = HttpRequest.newBuilder();

			HttpRequestBuilder.uri(URI.create(url)).timeout(Duration.ofMillis(75000)).header("Content-Type", "application/json");

			String payload = null;
			if (body != null) {
				payload = gson.toJson(body);
				HttpRequestBuilder.POST(BodyPublishers.ofByteArray(payload.getBytes(CHARSET)));
			}
			if (token != null) {
				HttpRequestBuilder.setHeader("Authorization", HEADER_NAME + " " + token);
			}
			LOGGER.info("http service request url [{}] - payload [{}]", url, payload);
			long start = System.currentTimeMillis();

			CompletableFuture<HttpResponse<String>> response = client.sendAsync(HttpRequestBuilder.build(), BodyHandlers.ofString());

			LOGGER.info("http service request async done in {} milliseconds", (System.currentTimeMillis() - start));

			return response;
		} catch (Throwable ex) {
			throw new BadRequestException(String.format("Error in university http service [%s]", ex.getMessage()), ex);
		}
	}

	private <T> Map<String, String> getHeaders(HttpResponse<T> response) {
		Map<String, String> headers = new HashMap<>();
		for (String name : response.headers().map().keySet()) {
			Optional<String> optValue = response.headers().firstValue(name);
			if (optValue.isPresent()) {
				headers.put(name, optValue.get());
			}
		}
		;
		return headers;
	}

	public <T> UniversityInternalResponse<T> getResponse(String source, Class<T> target) {
		return gson.fromJson(source, getType(UniversityInternalResponse.class, target));
	}

	private Type getType(final Class<?> rawClass, final Class<?> parameterClass) {
		return new ParameterizedType() {

			@Override
			public Type getRawType() {
				return rawClass;
			}

			@Override
			public Type getOwnerType() {
				return null;
			}

			@Override
			public Type[] getActualTypeArguments() {
				return new Type[] { parameterClass };
			}

		};
	}

	public static class UniversityResponse<T> {

		private UniversityInternalResponse<T> response;
		private Map<String, String> headers;

		public UniversityInternalResponse<T> getResponse() {
			return response;
		}

		public void setResponse(UniversityInternalResponse<T> response) {
			this.response = response;
		}

		public Map<String, String> getHeaders() {
			return headers;
		}

		public void setHeaders(Map<String, String> headers) {
			this.headers = headers;
		}

	}

	public static class UniversityInternalResponse<T> {

		private boolean success;
		private int code;
		private String message;
		private T data;

		public boolean getSuccess() {
			return success;
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public Optional<T> getData() {
			return Optional.ofNullable(data);
		}
	}
}
