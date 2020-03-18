package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class OptionValue extends BooleanValueObject {
	private static final long serialVersionUID = 1L;

	public OptionValue(Boolean value) {
		super(value);
		verifyIsBlank("option value", ErrorConstantsShared.BAD_QUESTION_DATA);
	}
}