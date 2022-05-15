package com.bulatovda.esport.modules.users.services;

import com.bulatovda.esport.modules.users.entities.DUserEntity;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import com.bulatovda.esport.modules.users.repositories.DUserRepository;
import com.bulatovda.esport.modules.users.services.interfaces.DUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class DUserServiceImpl implements DUserService {
	private final DUserRepository dUserRepository;
	private final BCryptPasswordEncoder encoder;

	@Override
	public DUserEntity addUserPassword(long userId, String password) {
		String encodedPassword = encoder.encode(password);
		UserEntity user = UserEntity.builder().id(userId).build();
		DUserEntity dUser = new DUserEntity(user, encodedPassword);
		return dUserRepository.save(dUser);
	}

	@Override
	public boolean validateUserPassword(long userId, String password) {
		DUserEntity dUserEntity = dUserRepository.findByUserId(userId).orElseThrow();
		return encoder.matches(password, dUserEntity.getPassword());
	}
}
