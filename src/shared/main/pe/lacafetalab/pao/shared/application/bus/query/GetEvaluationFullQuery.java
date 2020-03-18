package pe.lacafetalab.pao.shared.application.bus.query;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;

@Getter
public class GetEvaluationFullQuery implements Query {
	private String courseId;
	private String evaluationId;

	public GetEvaluationFullQuery(String courseId, String evaluationId) {
		super();
		this.courseId = courseId;
		this.evaluationId = evaluationId;
	}

}