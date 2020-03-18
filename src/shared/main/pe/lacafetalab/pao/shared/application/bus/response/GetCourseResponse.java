package pe.lacafetalab.pao.shared.application.bus.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@Builder
public class GetCourseResponse implements Response {

	private String courseId;
	private String name;
	private String description;
	private String language;
	private String level;
	private Integer duration;
	private Integer numThemes;
	private List<String> contentTypes;
	private IntroductionPr introduction;
	private List<String> achievements;
	private List<UnityPr> unities;

	@Getter
	@Builder
	public static class UnityPr {
		private String unityId;
		private String name;
		private String description;
		private Integer order;
		private Integer duration;
		private IntroductionPr introduction;
		private List<String> achievements;
		private List<ThemePr> themes;

	}

	@Getter
	@Builder
	public static class ThemePr {
		private String themeId;
		private String name;
		private Integer order;
		private Integer duration;
		private Integer weekNumber;
		private List<ContentPr> contents;

	}

	@Getter
	@Builder
	public static class ContentPr {

		private String contentId;
		private String title;
		private String description;
		private Integer order;
		private String type;
		private MetadataP metadata;

	}

	@Getter
	@Builder
	public static class MetadataMultimediaP extends MetadataP {
		private List<FormatP> formats;

		@Getter
		@Builder
		public static class FormatP {

			private String formatId;
			private Integer duration;
			private String url;
			private String type;
		}
	}

	@Getter
	@Builder
	public static class MetadataEvaluationsP extends MetadataP {

		private String type;
		private String evaluationId;

//		@Getter
//		@Builder
//		static class EvaluationP {
//			private String evaluationId;
//			private String sectionCode;
//
//		}
	}

	@Getter
	public static class MetadataTaskP extends MetadataP {

	}

	public static class MetadataP {

	}

	@Getter
	@Builder
	public static class IntroductionPr {
		private String videoUrl;
		private String imageUrl;
		private Integer width;
		private Integer height;

	}

}
