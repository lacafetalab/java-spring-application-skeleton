package pe.lacafetalab.pao.shared.domain;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.valueobject.Role;
import pe.lacafetalab.pao.shared.domain.valueobject.UserId;

@Getter
@Builder
public class UserIdentification {

	private UserId userId;
	private Role role;
	private AuthProvider provider;

	public UserIdentification(UserId userId, Role role, AuthProvider provider) {
		this.userId = userId;
		this.role = role;
		this.provider = provider;
	}
}
