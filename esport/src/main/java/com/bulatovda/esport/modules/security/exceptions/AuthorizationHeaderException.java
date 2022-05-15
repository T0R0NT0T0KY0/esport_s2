package com.bulatovda.esport.modules.security.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter()
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationHeaderException extends AuthenticationException {
	private final HttpStatus httpStatus;

	public AuthorizationHeaderException(String msg, Throwable cause) {
		super(msg, cause);
		this.httpStatus = HttpStatus.UNAUTHORIZED;
	}

	public AuthorizationHeaderException() {
		super("Token Not Valid");
		this.httpStatus = HttpStatus.UNAUTHORIZED;
	}
}
