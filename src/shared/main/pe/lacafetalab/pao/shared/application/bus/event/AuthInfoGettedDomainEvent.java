package pe.lacafetalab.pao.shared.application.bus.event;

import java.io.Serializable;
import java.util.HashMap;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.event.DomainEvent;

@Getter
public final class AuthInfoGettedDomainEvent extends DomainEvent {
	private final String token;

	public AuthInfoGettedDomainEvent() {
		super(null);
		this.token = null;
	}

	public AuthInfoGettedDomainEvent(String aggregateId, String token) {
		super(aggregateId);

		this.token = token;
	}

	public AuthInfoGettedDomainEvent(String aggregateId, String eventId, String occurredOn, String token) {
		super(aggregateId, eventId, occurredOn);
		this.token = token;
	}

	@Override
	public String eventName() {
		return "student.logged";
	}

	@Override
	@SuppressWarnings("serial")
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {
			{
				put("token", token);
			}
		};
	}

	@Override
	public AuthInfoGettedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new AuthInfoGettedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("token"));
	}

	public String token() {
		return token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		AuthInfoGettedDomainEvent other = (AuthInfoGettedDomainEvent) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

}
