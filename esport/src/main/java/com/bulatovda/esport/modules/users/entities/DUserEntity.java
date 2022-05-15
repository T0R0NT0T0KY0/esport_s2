package com.bulatovda.esport.modules.users.entities;

import com.bulatovda.esport.helpers.db.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "d_users")
public class DUserEntity extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String password;

	public DUserEntity(UserEntity user, String password) {
		this.user = user;
		this.password = password;
	}
}
