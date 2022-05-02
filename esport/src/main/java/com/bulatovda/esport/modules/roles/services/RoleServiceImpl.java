package com.bulatovda.esport.modules.roles.services;

import com.bulatovda.esport.helpers.carriers.ErrData;
import com.bulatovda.esport.helpers.carriers.ErrInfo;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.users.errors.UserErrors;
import com.bulatovda.esport.modules.roles.entities.RoleEntity;
import com.bulatovda.esport.modules.roles.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	@Override
	public ErrData<CustomErrorImpl, RoleEntity> addRole(String roleName) {
		ErrInfo<CustomErrorImpl, RoleEntity> errData = new ErrData<>();

		try {
			RoleEntity role = RoleEntity.builder()
					.name(roleName)
					.build();
			RoleEntity roleEntity = roleRepository.save(role);
			return errData.setData(roleEntity);
		} catch (Exception e) {
			return errData.setError(
					UserErrors.createError("Неизвестная ошибка создания роли", e.getLocalizedMessage()));
		}
	}
}
