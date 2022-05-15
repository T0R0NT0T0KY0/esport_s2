package com.bulatovda.esport.modules.security.exceptions;

import com.bulatovda.esport.helpers.errors.CustomErrorImpl;

public class AuthExceptions {

	public static CustomErrorImpl invalidSupplied() {
		return new CustomErrorImpl("неверный ввод", "Неверное предоставленное имя пользователя/пароль");
	}
}
