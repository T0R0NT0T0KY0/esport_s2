package com.bulatovda.esport.modules.users.services;

import com.bulatovda.esport.helpers.carriers.ErrorData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.roles.enums.UserRoleEnum;
import com.bulatovda.esport.modules.roles.services.UserRoleService;
import com.bulatovda.esport.modules.roles.services.UserRoleServiceImpl;
import com.bulatovda.esport.modules.security.JwtTokenProvider;
import com.bulatovda.esport.modules.security.dto.TokenDto;
import com.bulatovda.esport.modules.security.exceptions.AuthExceptions;
import com.bulatovda.esport.modules.users.dto.CreateUserDto;
import com.bulatovda.esport.modules.users.dto.UserDto;
import com.bulatovda.esport.modules.users.entities.UserEntity;
import com.bulatovda.esport.modules.users.exceptions.UserExceptions;
import com.bulatovda.esport.modules.users.repositories.UserRepository;
import com.bulatovda.esport.modules.users.services.interfaces.DUserService;
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
	private final DUserService dUserServiceImpl;
	private final UserRoleService userRoleService;
	private final JwtTokenProvider jwtTokenProvider;

	public ErrorData<CustomErrorImpl, UserDto> addUser(CreateUserDto createUserDto) {
		ErrorData<CustomErrorImpl, UserDto> errData = new ErrorData<>();

		try {
			Optional<UserEntity> userByUsername = userRepository.findByUsername(createUserDto.getUsername());
			if (userByUsername.isPresent()) {
				return errData.setError(UserExceptions.createUserNotUniqueUsername());
			}

			UserEntity newUser = UserEntity.builder()
					.username(createUserDto.getUsername())
					.build();

			UserEntity savedUser = userRepository.save(newUser);
			long userId = newUser.getId();
			dUserServiceImpl.addUserPassword(userId, createUserDto.getPassword());
			userRoleService.addRoleToUser(userId, UserRoleEnum.USER);


			errData.setData(new UserDto(savedUser));
			return errData;
		} catch (Exception e) {
			return errData.setError(
					UserExceptions.createUserUnknownException(e.getLocalizedMessage()));
		}
	}

	@Override
	public ErrorData<CustomErrorImpl, TokenDto> signin(String username, String password) {
		ErrorData<CustomErrorImpl, TokenDto> errorData = new ErrorData();
		try {
			UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();
			if (!dUserServiceImpl.validateUserPassword(userEntity.getId(), password)) {
				return errorData.setError(AuthExceptions.invalidSupplied());
			}
			String token = jwtTokenProvider.createToken(userEntity);
			return errorData.setData(new TokenDto(token));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return errorData.setError(AuthExceptions.invalidSupplied());
		}
	}

	@Override
	public ErrorData<CustomErrorImpl, UserDto> getUserById(long userId) {
		ErrorData<CustomErrorImpl, UserDto> errData = new ErrorData<>();
		Optional<UserEntity> user = this.userRepository.findById(userId);
		if (user.isEmpty()) {
			return errData.setError(UserExceptions.noUser());
		}
		return errData.setData(new UserDto(user.get()));
	}
}
