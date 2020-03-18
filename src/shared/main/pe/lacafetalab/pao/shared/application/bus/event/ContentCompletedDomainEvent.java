package pe.lacafetalab.pao.shared.application.bus.event;

import java.io.Serializable;
import java.util.HashMap;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.event.DomainEvent;

@Getter
public final class ContentCompletedDomainEvent extends DomainEvent {

	private final String userId;
	private final String courseId;
	private final String contentId;
	private final String propertiesType;

	public ContentCompletedDomainEvent() {
		super(null);
		this.userId = null;
		this.courseId = null;
		this.contentId = null;
		this.propertiesType = null;
	}

	public ContentCompletedDomainEvent(String aggregateId, String userId, String courseId, String contentId, String propertiesType) {
		super(aggregateId);
		this.userId = userId;
		this.courseId = courseId;
		this.contentId = contentId;
		this.propertiesType = propertiesType;
	}

	public ContentCompletedDomainEvent(String aggregateId, String eventId, String occurredOn, String userId, String courseId, String contentId, String propertiesType) {
		super(aggregateId, eventId, occurredOn);
		this.userId = userId;
		this.courseId = courseId;
		this.contentId = contentId;
		this.propertiesType = propertiesType;
	}

	@Override
	public String eventName() {
		return "content.completed";
	}

	@Override
	@SuppressWarnings("serial")
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {
			{
				put("userId", userId);
				put("courseId", courseId);
				put("contentId", contentId);
				put("propertiesType", propertiesType);
			}
		};
	}

	@Override
	public ContentCompletedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new ContentCompletedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("userId"), (String) body.get("courseId"), (String) body.get("contentId"), (String) body.get("propertiesType"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((propertiesType == null) ? 0 : propertiesType.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentCompletedDomainEvent other = (ContentCompletedDomainEvent) obj;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (propertiesType == null) {
			if (other.propertiesType != null)
				return false;
		} else if (!propertiesType.equals(other.propertiesType))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
