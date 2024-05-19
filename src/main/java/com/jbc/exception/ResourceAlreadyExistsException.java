package com.jbc.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ResourceAlreadyExistsException extends RuntimeException {

	public ResourceAlreadyExistsException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
}
