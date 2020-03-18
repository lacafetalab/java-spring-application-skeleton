package pe.lacafetalab.pao.shared.domain;

import java.util.Optional;

import pe.lacafetalab.pao.shared.domain.valueobject.EnumValueObject;
import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.utils.EnumTypeUtils;

public class AuthProvider extends EnumValueObject<AuthProvider.Provider> {

	private static BadRequestException INVALID_VALUE = new BadRequestException("Invalid provider value", ErrorConstantsShared.BAD_PROVIDER);

	public AuthProvider(Provider status) {
		super(status);
	}

	public AuthProvider(String str) {
		this(Provider.valueFrom(str).orElseThrow(() -> INVALID_VALUE));
	}

	public enum Provider {
		STUDENT, CUSTOM;

		public static Optional<Provider> valueFrom(String str) {
			return EnumTypeUtils.valueFrom(str, Provider.class);
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}
	}
}
