package com.bulatovda.esport.modules.users.services;

import com.bulatovda.esport.helpers.carriers.ErrData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.users.dto.CreateUserDto;
import com.bulatovda.esport.modules.users.dto.UserDto;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import com.bulatovda.esport.modules.users.errors.UserErrors;
import com.bulatovda.esport.modules.users.repositories.UserRepository;
import com.bulatovda.esport.modules.users.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final DUserServiceImpl dUserServiceImpl;


	public ErrData<CustomErrorImpl, UserDto> addUser(CreateUserDto createUserDto) {
		ErrData<CustomErrorImpl, UserDto> errData = new ErrData<>();

		try {
			Optional<UserEntity> userByEmail = userRepository.findByEmail(createUserDto.getEmail());
			if (userByEmail.isPresent()) {
				return errData.setError(UserErrors.notUniqueEmail("Ошибка создания пользователя"));
			}

			UserEntity newUser = UserEntity.builder()
					.email(createUserDto.getEmail())
					.username(createUserDto.getUsername())
					.build();

			UserEntity savedUser = userRepository.save(newUser);
			dUserServiceImpl.addUserPassword(newUser, createUserDto.getPassword());

			errData.setData(new UserDto(savedUser));
			return errData;
		} catch (Exception e) {
			return errData.setError(
					UserErrors.createError("Неизвестная ошибка создания пользователя", e.getLocalizedMessage()));
		}
	}

}
