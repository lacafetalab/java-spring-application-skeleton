package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.Optional;

import pe.lacafetalab.pao.shared.utils.EnumTypeUtils;

public class EvaluationType extends EnumValueObject<EvaluationType.Type> {

	public EvaluationType(Type value) {
		super(value);
	}

	public EvaluationType(String value) {
		this(Type.valueFrom(value).get());
	}

	public static enum Type {

		PC1, PC2, PC3, PC4, PC5, PC6, EXPA, EXFI;

		public static Optional<Type> valueFrom(String str) {
			return EnumTypeUtils.valueFrom(str, Type.class);
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}
	}
}