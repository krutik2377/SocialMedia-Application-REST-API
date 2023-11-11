package com.SMARA.restAPIs.SMARESTAPI.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// response status will convert internal error status to given provided not found exception.
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFountException extends RuntimeException {
	
	public UserNotFountException(String message)
	{
		super(message);
	}
}
