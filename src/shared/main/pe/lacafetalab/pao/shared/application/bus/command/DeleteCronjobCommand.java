package pe.lacafetalab.pao.shared.application.bus.command;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class DeleteCronjobCommand implements Command {

	private String userId;
	private String entityId;

	public DeleteCronjobCommand(String userId, String entityId) {
		super();
		this.userId = userId;
		this.entityId = entityId;
	}
}