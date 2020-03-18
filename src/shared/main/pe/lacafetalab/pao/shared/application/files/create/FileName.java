package pe.lacafetalab.pao.shared.application.files.create;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.valueobject.StringValueObject;

@Getter
public class FileName extends StringValueObject {
	private static final long serialVersionUID = 1L;

	protected FileName() {
	}

	public FileName(String value) {
		super(value);
		verifyNotBlank("File Name", ErrorConstantsShared.BAD_FILENAME);
	}
}