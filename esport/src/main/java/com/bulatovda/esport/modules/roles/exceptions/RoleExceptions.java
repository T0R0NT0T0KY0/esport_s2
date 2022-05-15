package com.bulatovda.esport.modules.roles.exceptions;

import com.bulatovda.esport.helpers.errors.CustomErrorImpl;


public class RoleExceptions {

	public static CustomErrorImpl noRoleByName() {
		return new CustomErrorImpl("Плохой запрос", "Роль с такимназванием не найдена");
	}
}
