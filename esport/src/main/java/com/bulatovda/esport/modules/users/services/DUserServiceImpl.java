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
	public DUserEntity addUserPassword(UserEntity user, String password) {
		String encodedPassword = encoder.encode(password);
		DUserEntity dUser = new DUserEntity(user, encodedPassword);
		return dUserRepository.save(dUser);
	}
}
