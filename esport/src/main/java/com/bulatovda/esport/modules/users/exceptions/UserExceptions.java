package com.bulatovda.esport.modules.users.exceptions;

import com.bulatovda.esport.helpers.errors.CustomErrorImpl;


public class UserExceptions {

	public static CustomErrorImpl createUserNotUniqueUsername() {
		return new CustomErrorImpl("Ошибка создания пользователя", "Пользователь с таким username уже существует");
	}


	public static CustomErrorImpl createUserRoleUnknownException(String localizedMessage) {
		return new CustomErrorImpl("Неизвестная ошибка создания пользователя", localizedMessage);
	}

	public static CustomErrorImpl createUserUnknownException(String localizedMessage) {
		return new CustomErrorImpl("Неизвестная ошибка создания пользователя", localizedMessage);
	}
	public static CustomErrorImpl noUser() {
		return new CustomErrorImpl("Плохой запрос", "Пользователь не найден");
	}
}
