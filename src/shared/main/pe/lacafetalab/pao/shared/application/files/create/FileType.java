package pe.lacafetalab.pao.shared.application.files.create;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.valueobject.StringValueObject;

@Getter
public class FileType extends StringValueObject {
	private static final long serialVersionUID = 1L;

	protected FileType() {
	}

	public FileType(String value) {
		super(value);
		verifyNotBlank("File Type", ErrorConstantsShared.BAD_FILETYPE);
	}

}