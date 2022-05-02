package com.bulatovda.esport.modules.users.entities;


import com.bulatovda.esport.modules.roles.entities.UsersRolesEntity;
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
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, insertable = false)
	private long id;

	@Column(unique = true, nullable = false, columnDefinition = "TEXT")
	private String email;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String username;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<UsersRolesEntity> userRoles = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<DUserEntity> userPasswords = new ArrayList<>();

	@CreatedDate
	@Column(nullable = false, name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(nullable = false, name = "updated_at", updatable = true, insertable = false)
	private LocalDateTime updatedAt;
}
