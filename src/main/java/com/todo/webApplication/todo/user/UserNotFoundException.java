package com.todo.webApplication.todo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

}
