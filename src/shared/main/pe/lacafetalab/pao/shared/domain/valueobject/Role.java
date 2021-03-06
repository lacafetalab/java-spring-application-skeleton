package pe.lacafetalab.pao.shared.domain.valueobject;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;

public class Role extends StringValueObject {
	private static final long serialVersionUID = 1L;

	protected Role() {
	}

	public Role(String value) {
		super(value);
		if (StringUtils.isBlank(value)) {
			throw new BadRequestException("The role must not be empty", ErrorConstantsShared.BAD_ROLE);
		}
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
