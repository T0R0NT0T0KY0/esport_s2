package com.bulatovda.esport.modules.users.controllers;

import com.bulatovda.esport.helpers.carriers.ErrData;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;
import com.bulatovda.esport.modules.users.dto.CreateUserDto;
import com.bulatovda.esport.modules.users.dto.UserDto;
import com.bulatovda.esport.modules.users.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("registration")
	public ResponseEntity registerUser(@Valid @RequestBody CreateUserDto createUserDTO) {
		ErrData<CustomErrorImpl, UserDto> errorData = userServiceImpl.addUser(createUserDTO);
		CustomErrorImpl error = errorData.getError();
		if (Objects.nonNull(error)) {return ResponseEntity.badRequest().body(error);}

		UserDto user = errorData.getData();
		return ResponseEntity.ok(user);
	}
}
