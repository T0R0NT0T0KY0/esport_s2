package com.bulatovda.esport.modules.users.entities;


import com.bulatovda.esport.helpers.db.BaseEntity;
import com.bulatovda.esport.modules.roles.entities.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	@Column(unique = true, nullable = false, columnDefinition = "TEXT")
	private String username;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserRoleEntity> userRoles = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<DUserEntity> userPasswords = new ArrayList<>();

	@Builder
	public UserEntity(long id, LocalDateTime createdAt, LocalDateTime updatedAt, String username,
	                  List<UserRoleEntity> userRoles, List<DUserEntity> userPasswords) {
		super(id, createdAt, updatedAt);
		this.username = username;
		this.userRoles = userRoles;
		this.userPasswords = userPasswords;
	}
}
