package com.bulatovda.esport.modules.users.services.interfaces;

import com.bulatovda.esport.helpers.carriers.ErrorData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.security.dto.TokenDto;
import com.bulatovda.esport.modules.users.dto.CreateUserDto;
import com.bulatovda.esport.modules.users.dto.UserDto;

public interface UserService {
	ErrorData<CustomErrorImpl, UserDto> addUser(CreateUserDto createUserDto);

	ErrorData<CustomErrorImpl, TokenDto> signin(String username, String password);

	ErrorData<CustomErrorImpl, UserDto> getUserById(long userId);
}
