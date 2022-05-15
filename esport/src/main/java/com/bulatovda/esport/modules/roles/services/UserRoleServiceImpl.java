package com.bulatovda.esport.modules.roles.services;

import com.bulatovda.esport.modules.roles.entities.RoleEntity;
import com.bulatovda.esport.modules.roles.entities.UserRoleEntity;
import com.bulatovda.esport.modules.roles.enums.UserRoleEnum;
import com.bulatovda.esport.modules.roles.repositories.RoleRepository;
import com.bulatovda.esport.modules.roles.repositories.UserRoleRepository;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import com.bulatovda.esport.modules.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {
	private final UserRoleRepository userRoleRepository;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	@Override
	public UserRoleEntity addRoleToUser(long userId, UserRoleEnum roleName) {
		RoleEntity role = this.roleRepository.findByName(roleName.getRoleName()).orElseThrow();
		UserEntity user = UserEntity.builder().id(userId).build();
		UserRoleEntity userRole = UserRoleEntity.builder().role(role).user(user).build();
		return userRoleRepository.save(userRole);
	}
}
