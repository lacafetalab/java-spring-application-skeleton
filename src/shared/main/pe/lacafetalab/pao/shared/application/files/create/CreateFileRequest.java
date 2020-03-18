package pe.lacafetalab.pao.shared.application.files.create;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@SuppressWarnings("unused")
public class CreateFileRequest {

	private String application_path;
	private String file_name;
	private String file_type;

	public CreateFileRequest(String application_path, String file_name, String file_type) {
		super();
		this.application_path = application_path;
		this.file_name = file_name;
		this.file_type = file_type;
	}

}
