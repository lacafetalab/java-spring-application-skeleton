package pe.lacafetalab.pao.shared.application.files.create;

import lombok.Getter;
import pe.lacafetalab.pao.shared.application.QueryBase;

@Getter
public class CreateFileInput extends QueryBase {

	private ApplicationPath applicationPath;
	private FileName fileName;
	private FileType fileType;

	public CreateFileInput(CreateFileCommand command) {
		super();
		this.applicationPath = new ApplicationPath(command.getApplication_path());
		this.fileName = new FileName(command.getFile_name());
		this.fileType = new FileType(command.getFile_type());
	}
}