package com.bulatovda.esport.modules.users.controllers;

import com.bulatovda.esport.helpers.carriers.ErrorData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.security.dto.SingInDto;
import com.bulatovda.esport.modules.security.dto.TokenDto;
import com.bulatovda.esport.modules.users.dto.CreateUserDto;
import com.bulatovda.esport.modules.users.dto.UserDto;
import com.bulatovda.esport.modules.users.services.UserServiceImpl;
import com.bulatovda.esport.modules.users.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("signup")
	public ResponseEntity registerUser(@Valid @RequestBody CreateUserDto createUserDTO) {
		ErrorData<CustomErrorImpl, UserDto> errorData = userService.addUser(createUserDTO);
		CustomErrorImpl error = errorData.getError();
		if (Objects.nonNull(error)) {
			return ResponseEntity.badRequest().body(error);
		}

		UserDto user = errorData.getData();
		return ResponseEntity.ok(user);
	}

	@PostMapping("/signin")
	public ResponseEntity login(@Valid @RequestBody SingInDto singInDto) {
		ErrorData<CustomErrorImpl, TokenDto> errorData = userService.signin(singInDto.getUsername(),
				singInDto.getPassword());
		CustomErrorImpl error = errorData.getError();
		if (Objects.nonNull(error)) {
			return ResponseEntity.badRequest().body(error);
		}

		TokenDto token = errorData.getData();
		return ResponseEntity.ok(token);
	}
	@GetMapping("/{userId}")
	public ResponseEntity getUserById(@PathVariable(value="userId") long userId) {
		ErrorData<CustomErrorImpl, UserDto> errorData = userService.getUserById(userId);
		CustomErrorImpl error = errorData.getError();
		if (Objects.nonNull(error)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}

		UserDto user = errorData.getData();
		return ResponseEntity.ok(user);
	}
}
