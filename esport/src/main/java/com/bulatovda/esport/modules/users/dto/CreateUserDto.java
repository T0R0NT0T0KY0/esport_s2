package com.bulatovda.esport.modules.users.dto;

import com.bulatovda.esport.helpers.validators.ValidPassword;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateUserDto extends AbstractUserDto {

	@NotNull
	@Size(min = 5, message = "The password must be longer than 5 characters")
	@ValidPassword
	private String password;

	public CreateUserDto(String username, String password) {
		super(username);
		this.password = password;
	}
}
