package com.bulatovda.esport.modules.roles.services;

import com.bulatovda.esport.helpers.carriers.ErrorData;
import com.bulatovda.esport.helpers.carriers.ErrorInfo;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.roles.enums.UserRoleEnum;
import com.bulatovda.esport.modules.roles.exceptions.RoleExceptions;
import com.bulatovda.esport.modules.users.exceptions.UserExceptions;
import com.bulatovda.esport.modules.roles.entities.RoleEntity;
import com.bulatovda.esport.modules.roles.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	@Override
	public ErrorData<CustomErrorImpl, RoleEntity> addRole(String roleName) {
		ErrorInfo<CustomErrorImpl, RoleEntity> errData = new ErrorData<>();

		try {
			RoleEntity role = RoleEntity.builder()
					.name(roleName)
					.build();
			RoleEntity roleEntity = roleRepository.save(role);
			return errData.setData(roleEntity);
		} catch (Exception e) {
			return errData.setError(
					UserExceptions.createUserRoleUnknownException(e.getLocalizedMessage()));
		}
	}

	@Override
	public ErrorData<CustomErrorImpl, RoleEntity> findRoleByName(UserRoleEnum roleName) {
		ErrorData<CustomErrorImpl, RoleEntity> errorData = new ErrorData<>();
		Optional<RoleEntity> role = this.roleRepository.findByName(roleName.getRoleName());
		if (role.isEmpty()) {
			return errorData.setError(RoleExceptions.noRoleByName());
		}
		return errorData.setData(role.get());
	}
}
