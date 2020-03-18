package pe.lacafetalab.pao.shared.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class UUIDValueObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String value;

	protected UUIDValueObject() {
	}

	public UUIDValueObject(String uuid) {
		verify(uuid);
		this.value = uuid;
	}

	public static void verify(String uuid) {
		if (!isValidate(uuid)) {
			throw new BadRequestException("Uuid value no valid");
		}
	}

	public static boolean isValidate(String uuid) {
		try {
			UUID.fromString(uuid);
			return true;
		} catch (IllegalArgumentException | NullPointerException exception) {
			return false;
		}
	}

	public String value() {
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
		UUIDValueObject other = (UUIDValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
