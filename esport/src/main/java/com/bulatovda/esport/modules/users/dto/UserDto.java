package com.bulatovda.esport.modules.users.dto;

import com.bulatovda.esport.modules.users.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto extends AbstractUserDto {
	private long userId;

	private String username;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public UserDto(UserEntity user) {
		super(user.getUsername());
		this.userId = user.getId();
		this.username = user.getUsername();
		this.createdAt = user.getCreatedAt();
		this.updatedAt = user.getUpdatedAt();
	}
}
