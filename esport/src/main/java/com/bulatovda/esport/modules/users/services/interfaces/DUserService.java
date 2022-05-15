package com.bulatovda.esport.modules.users.services.interfaces;

import com.bulatovda.esport.modules.users.entities.DUserEntity;
import com.bulatovda.esport.modules.users.entities.UserEntity;

public interface DUserService {
	DUserEntity addUserPassword(long userId, String password);

	boolean validateUserPassword(long userId, String password);
}
