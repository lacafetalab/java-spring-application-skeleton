package pe.lacafetalab.pao.shared.domain.valueobject;

import java.util.List;
import java.util.Optional;

import pe.lacafetalab.pao.shared.exceptions.BadRequestException;
import pe.lacafetalab.pao.shared.utils.EnumTypeUtils;

public class QuestionType extends EnumValueObject<QuestionType.Type> {

	public static BadRequestException INVALID_VALUE = new BadRequestException("Invalid question type");

	public QuestionType(Type value) {
		super(value);
		if (value == null) {
			throw INVALID_VALUE;
		}
	}

	public QuestionType(String value) {
		this(Type.valueFrom(value).orElseThrow(() -> INVALID_VALUE));
	}

	public boolean isOptionType() {
		return List.of(Type.ONEOPTION, Type.MULTIOPTION).contains(value());
	}

	public static enum Type {
		ONEOPTION, MULTIOPTION, OPENANSWER;

		public static Optional<Type> valueFrom(String str) {
			return EnumTypeUtils.valueFrom(str, Type.class);
		}

		public static boolean isValid(String str) {
			return valueFrom(str).isPresent();
		}
	}
}