package pe.lacafetalab.pao.shared.application.bus.command;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class CompleteContentCommand implements Command {

	private String courseId;
	private String contentId;
	private String userId;

	public CompleteContentCommand(String courseId, String contentId, String userId) {
		super();
		this.courseId = courseId;
		this.contentId = contentId;
		this.userId = userId;
	}
}