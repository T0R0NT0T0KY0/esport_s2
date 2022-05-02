package com.bulatovda.esport.modules.users.services.interfaces;

import com.bulatovda.esport.helpers.carriers.ErrData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.users.dto.CreateUserDto;
import com.bulatovda.esport.modules.users.dto.UserDto;

public interface UserService {
	ErrData<CustomErrorImpl, UserDto> addUser(CreateUserDto createUserDto);
}
