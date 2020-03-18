package pe.lacafetalab.pao.shared.application.bus.query;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;

@Getter
public class GetCourseProgressQuery implements Query {

	private String userId;
	private String courseId;

	public GetCourseProgressQuery(String userId, String courseId) {
		super();
		this.userId = userId;
		this.courseId = courseId;
	}

}
