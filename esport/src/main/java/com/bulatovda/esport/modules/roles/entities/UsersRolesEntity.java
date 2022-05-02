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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users_roles")
public class UsersRolesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, insertable = false)
	private long id;

	@ManyToMany()
	@JoinColumn(name = "role_id")
	private List<RoleEntity> roles;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private List<UserEntity> users;

	@Column(nullable = false, name = "starts_at")
	private LocalDateTime startsAt;

	@Column(nullable = false, name = "ends_at")
	private LocalDateTime endsAt;

	@CreatedDate
	@Column(nullable = false, name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(nullable = false, name = "created_at", updatable = false, insertable = false)
	private LocalDateTime updatedAt;
}
