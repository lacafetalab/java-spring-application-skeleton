package pe.lacafetalab.pao.shared.domain.valueobject;

import lombok.Getter;

@Getter
public class WeekNumber extends IntegerValueObject {
	private static final long serialVersionUID = 1L;

	protected WeekNumber() {
	}

	public WeekNumber(Integer value) {
		super(value);
	}
}