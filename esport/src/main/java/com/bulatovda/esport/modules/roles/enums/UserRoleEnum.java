package com.bulatovda.esport.modules.roles.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
	USER("USER"),
	ADMIN("ADMIN");
	private final String roleName;

	UserRoleEnum(String roleName) {
		this.roleName = roleName;
	}
}
