package pe.lacafetalab.pao.shared.application.files.create;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.domain.valueobject.StringValueObject;

@Getter
public class ApplicationPath extends StringValueObject {
	private static final long serialVersionUID = 1L;

	protected ApplicationPath() {
	}

	public ApplicationPath(String value) {
		super(value);
		verifyNotBlank("Application Path", ErrorConstantsShared.BAD_APPLICATIONPATH);
	}

}