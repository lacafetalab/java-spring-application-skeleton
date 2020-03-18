package pe.lacafetalab.pao.shared.domain.valueobject;

import lombok.Getter;

@Getter
public class Duration extends IntegerValueObject {
	private static final long serialVersionUID = 1L;

	protected Duration() {
	}

	public Duration(Integer value) {
		super(value != null ? value : Integer.valueOf(0));
	}
}