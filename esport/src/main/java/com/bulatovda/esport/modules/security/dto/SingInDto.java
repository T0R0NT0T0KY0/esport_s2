package com.bulatovda.esport.modules.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingInDto {
	private final String username;
	private final String password;
}
