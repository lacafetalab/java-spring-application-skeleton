package pe.lacafetalab.pao.shared.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean success = false;
	@JsonIgnore
	private int statusCode;
	private int code;
	private String message;
	private Object data;
	
	public RestResponse(boolean success, int statusCode, int code, String message, Object data) {
		this.success = success;
		this.statusCode = statusCode;
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
