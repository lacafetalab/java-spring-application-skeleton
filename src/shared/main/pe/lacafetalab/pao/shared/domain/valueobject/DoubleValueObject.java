package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class DoubleValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double value;

	protected DoubleValueObject() {
	}

	public DoubleValueObject(Double value) {
		this.value = value;
	}

	public DoubleValueObject(String value, BadRequestException ex) {
		if (StringUtils.isBlank(value)) {
			throw ex;
		}
		try {
			this.value = Double.parseDouble(value);
		} catch (NumberFormatException | NullPointerException e) {
			throw ex;
		}
	}

	public Double value() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoubleValueObject other = (DoubleValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
