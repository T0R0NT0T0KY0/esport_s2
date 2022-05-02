package com.bulatovda.esport.modules.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractUserDto {
	@NotNull
	@Email(message = "That is not a valid email address", regexp = ".+@.+\\..+")
	private String email;

	@NotNull
	@Size(min = 2, max = 30)
	private String username;
}
