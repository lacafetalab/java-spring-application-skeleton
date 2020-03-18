package pe.lacafetalab.pao.shared.application.bus.response;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@Builder
public class GetCourseProgressResponse implements Response {

	private String courseId;
	private String status;
	private Double value;
	private String activeUnityId;
	private List<WeekStatus> weeks;
	private List<GetCourseProgressResponse.Unity> unities;

	@Getter
	@Builder
	public static class WeekStatus {
		private Integer weekNumber;
		private String status;
	}

	@Getter
	@Builder
	public static class Unity {
		private String unityId;
		private String status;
		private Double value;
		private String activeThemeId;
		private List<GetCourseProgressResponse.Theme> themes;

	}

	@Getter
	@Builder
	public static class Theme {
		private String themeId;
		private String status;
		private Double value;
		private String activeContentId;
		private List<GetCourseProgressResponse.Content> contents;

	}

	@Getter
	@Builder
	public static class Content {
		private String contentId;
		private String status;
		private Double value;
		private ContentPropertiesBase properties;
	}

	public static class ContentPropertiesBase {

	}

	@Getter
	@Builder
	public static class ContentEvaluationProperties extends ContentPropertiesBase {
		private Date nowTime;
		private Date startTime;
		private Integer leftDuration;
		private List<EvaluationQuestionProperty> questions;
	}

	@Getter
	@Builder
	public static class EvaluationQuestionProperty {
		private String questionId;
		private String type;
		private QuestionPropertyData data;
	}

	public static class QuestionPropertyData {
	}

	@Getter
	@Builder
	public static class QuestionOpenAnswerData extends QuestionPropertyData {
		private String answer;
	}

	@Getter
	@Builder
	public static class QuestionMultiOptionsData extends QuestionPropertyData {
		private List<String> optionsId;
	}

	@Getter
	@Builder
	public static class QuestionOneOptionData extends QuestionPropertyData {
		private String optionId;
	}

	@Getter
	@Builder
	public static class ContentTaskProperties extends ContentPropertiesBase {
		private List<TaskFileProperty> files;
	}

	@Getter
	@Builder
	public static class TaskFileProperty {
		private String url;
		private String name;
		private Integer size;
	}
}