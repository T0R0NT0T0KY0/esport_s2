package com.bulatovda.esport.modules.roles.services;

import com.bulatovda.esport.helpers.carriers.ErrData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.roles.entities.RoleEntity;

public interface RoleService {
	ErrData<CustomErrorImpl, RoleEntity> addRole(String roleName);
}
