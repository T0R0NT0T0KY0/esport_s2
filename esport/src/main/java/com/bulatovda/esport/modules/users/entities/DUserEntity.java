package com.bulatovda.esport.modules.users.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "d_users")
public class DUserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, insertable = false)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String password;

	@CreatedDate
	@Column(nullable = false, name = "created_at", updatable = false, insertable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(nullable = false, name = "updated_at", updatable = true, insertable = false)
	private LocalDateTime updatedAt;

	public DUserEntity(UserEntity user, String password) {
		this.user = user;
		this.password = password;
	}
}
