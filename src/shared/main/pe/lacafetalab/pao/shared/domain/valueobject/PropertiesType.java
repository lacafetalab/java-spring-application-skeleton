package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Optional;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.utils.EnumTypeUtils;

public class PropertiesType extends EnumValueObject<PropertiesType.Type> {

	private static BadRequestException INVALID_VALUE = new BadRequestException("Invalid properties type");

	public static PropertiesType NONE = new PropertiesType(PropertiesType.Type.NONE);

	public PropertiesType(Type type) {
		super(type);
	}

	public PropertiesType(String value) {
		this(Type.valueFrom(value).orElseThrow(() -> INVALID_VALUE));
	}

	public static enum Type {
		NONE, TASK, EVALUATION;

		public static Optional<Type> valueFrom(String str) {
			return EnumTypeUtils.valueFrom(str, Type.class);
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}
	}
}