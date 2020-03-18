package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class BooleanValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean value;

	protected BooleanValueObject() {
	}

	public BooleanValueObject(Boolean value) {
		this.value = value;
	}

	public BooleanValueObject(String value, BadRequestException ex) {
		this(value, ex, false);
	}

	public void verifyIsBlank(String name, int errorCode) {
		if (value() == null) {
			throw new BadRequestException(String.format("The %s must not be empty", name), errorCode);
		}
	}

	public BooleanValueObject(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value)
				&& (value.toLowerCase().equals("true") || value.toLowerCase().equals("false"))) {
			this.value = BooleanUtils.toBooleanObject(value);
		} else if (allowNull && value == null) {
			this.value = null;
		} else {
			throw ex;
		}
	}

	public Boolean value() {
		return value;
	}

}
