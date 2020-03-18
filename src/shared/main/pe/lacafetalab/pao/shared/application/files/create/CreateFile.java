package pe.lacafetalab.pao.shared.application.files.create;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.lacafetalab.pao.shared.application.ApplicationQuery;
import pe.lacafetalab.pao.shared.infrastructure.AuthHttpService;

@Service
public class CreateFile implements ApplicationQuery<Object, CreateFileInput> {

	private AuthHttpService authHttpService;
	private String createUrl;

	public CreateFile(AuthHttpService authHttpService, @Value("${service.files.create.url}") String createUrl) {
		this.authHttpService = authHttpService;
		this.createUrl = createUrl;
	}

	@Override
	public Object execute(CreateFileInput input) {
		CreateFileRequest request = new CreateFileRequest(input.getApplicationPath().value(), input.getFileName().value(), input.getFileType().value());
		Object response = authHttpService.doPost(createUrl, null, request, Object.class).get();
		return response;
	}
}