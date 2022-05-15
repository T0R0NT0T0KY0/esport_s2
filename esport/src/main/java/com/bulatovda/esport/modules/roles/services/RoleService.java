package com.bulatovda.esport.modules.roles.services;

import com.bulatovda.esport.helpers.carriers.ErrorData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.roles.entities.RoleEntity;
import com.bulatovda.esport.modules.roles.enums.UserRoleEnum;

public interface RoleService {
	ErrorData<CustomErrorImpl, RoleEntity> addRole(String roleName);

	ErrorData<CustomErrorImpl, RoleEntity> findRoleByName(UserRoleEnum roleName);
}
