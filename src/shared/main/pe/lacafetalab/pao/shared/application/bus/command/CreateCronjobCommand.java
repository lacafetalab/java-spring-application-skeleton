package pe.lacafetalab.pao.shared.application.bus.command;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
public class CreateCronjobCommand implements Command {

	private String userId;
	private String entityId;
	private String entityType;
	private Date deadline;
	private Map<String, Object> properties;

	public CreateCronjobCommand(String userId, String entityId, String entityType, Date deadline, Map<String, Object> properties) {
		super();
		this.userId = userId;
		this.entityId = entityId;
		this.entityType = entityType;
		this.deadline = deadline;
		this.properties = properties;
	}
}