package pe.lacafetalab.pao.shared.application;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAggregatePresentation implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;

	public CreateAggregatePresentation(String id) {
		this.id = id;
	}

	protected CreateAggregatePresentation() {
	}

}
