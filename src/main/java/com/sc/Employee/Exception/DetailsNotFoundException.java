package com.sc.Employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DetailsNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DetailsNotFoundException(String exception) {
		super(exception);
	}

}
