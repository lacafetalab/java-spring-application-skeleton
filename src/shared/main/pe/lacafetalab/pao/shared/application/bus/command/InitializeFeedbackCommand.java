package pe.lacafetalab.pao.shared.application.bus.command;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class InitializeFeedbackCommand implements Command {

	private String userId;
	private String courseId;
	private String contentId;
	private String evaluationId;

	public InitializeFeedbackCommand(String userId, String courseId, String contentId, String evaluationId) {
		super();
		this.userId = userId;
		this.courseId = courseId;
		this.contentId = contentId;
		this.evaluationId = evaluationId;
	}
}