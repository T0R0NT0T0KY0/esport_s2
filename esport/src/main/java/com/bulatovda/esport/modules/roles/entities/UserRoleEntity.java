package com.bulatovda.esport.modules.roles.entities;

import com.bulatovda.esport.helpers.db.BaseEntity;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_roles")
public class UserRoleEntity extends BaseEntity {
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private RoleEntity role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(nullable = false, name = "starts_at")
	private LocalDateTime startsAt;

	@Column(nullable = false, name = "ends_at")
	private LocalDateTime endsAt;

	@Builder
	public UserRoleEntity(long id, LocalDateTime createdAt, LocalDateTime updatedAt, RoleEntity role, UserEntity user,
	                      LocalDateTime startsAt, LocalDateTime endsAt) {
		super(id, createdAt, updatedAt);
		this.role = role;
		this.user = user;
		this.startsAt = startsAt;
		this.endsAt = endsAt;
	}
}
