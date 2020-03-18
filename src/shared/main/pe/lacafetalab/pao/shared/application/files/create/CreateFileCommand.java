package pe.lacafetalab.pao.shared.application.files.create;

import lombok.Getter;

@Getter
public class CreateFileCommand {

	private String application_path;
	private String file_name;
	private String file_type;

	protected CreateFileCommand() {
	}

}
