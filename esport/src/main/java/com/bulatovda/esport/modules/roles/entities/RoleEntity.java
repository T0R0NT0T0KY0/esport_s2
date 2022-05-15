package com.bulatovda.esport.modules.roles.entities;

import com.bulatovda.esport.helpers.db.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "d_roles")
@NoArgsConstructor
public class RoleEntity extends BaseEntity {
	@Column(nullable = false, columnDefinition = "TEXT", unique = true)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private List<UserRoleEntity> usersRoles = new ArrayList<>();

	@Builder
	public RoleEntity(long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name,
	                  List<UserRoleEntity> usersRoles) {
		super(id, createdAt, updatedAt);
		this.name = name;
		this.usersRoles = usersRoles;
	}
}
