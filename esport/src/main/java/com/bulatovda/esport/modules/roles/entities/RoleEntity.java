package com.bulatovda.esport.modules.roles.entities;

import com.bulatovda.esport.modules.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "d_roles")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, insertable = false)
	private long id;

	@Column(nullable = false, columnDefinition = "TEXT", unique = true)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<UsersRolesEntity> usersRoles = new ArrayList<>();

	@CreatedDate
	@Column(nullable = false, name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(nullable = false, name = "updated_at", updatable = true, insertable = false)
	private LocalDateTime updatedAt;
}
