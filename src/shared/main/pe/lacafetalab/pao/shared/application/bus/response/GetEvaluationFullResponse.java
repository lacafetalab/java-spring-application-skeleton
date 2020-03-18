package pe.lacafetalab.pao.shared.application.bus.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@Builder
public class GetEvaluationFullResponse implements Response {

	private String evaluationId;
	private String courseId;
	private String type;
	private String sectionCode;
	private List<QuestionResponse> questions;

	@Getter
	@Builder
	public static class QuestionResponse {
		private String questionId;
		private String description;
		private Double score;
		private String type;
		private QuestionDataResponse data;

	}

	@Getter
	public static class QuestionDataBlankResponse extends QuestionDataResponse {
	}

	@Getter
	@Builder
	public static class QuestionDataOptionsTypeResponse extends QuestionDataResponse {
		private List<OptionResponse> options;
	}

	@Getter
	public static class QuestionDataResponse {
	}

	@Getter
	@Builder
	public static class OptionResponse {
		private String optionId;
		private Boolean value;
		private String description;

	}
}