package com.jbc.exception;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.util.CustomObjectInputStream;
import org.apache.logging.log4j.message.Message;
import java.util.*;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // is used for exception handled from only controller class .
public class GlobalExceptionHandler {

//	@ExceptionHandler(ResourceAlreadyExistsException.class)
//	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
//		Map<String, String> errorMap = new HashMap<>();
//
//		List<FieldError> fieldErrors = ex.getFieldErrors();
//
//		for (FieldError fieldError : fieldErrors) {
//			String fieldName = fieldError.getField();
//			String massage = fieldError.getDefaultMessage();
//			errorMap.put(fieldName, massage);
//		}
//		return errorMap;
//	}

	@ExceptionHandler(SomethingWentWrong.class)
	public CustomExceptionResponce somethingWentWrong(SomethingWentWrong ex, HttpServletRequest hr) {
		String msg = ex.getMessage();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
		String path = hr.getRequestURI();
		CustomExceptionResponce response = new CustomExceptionResponce(path, timeStamp, msg);
		return response;
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public CustomExceptionResponce ResourceAlreadyExists(ResourceAlreadyExistsException ex,HttpServletRequest hr) {
		String msg = ex.getMessage();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
		String path = hr.getRequestURI();
		CustomExceptionResponce response = new CustomExceptionResponce(path, timeStamp, msg);
		return response;
	}
	
	@ExceptionHandler(ResourceNotExistsException.class)
	public CustomExceptionResponce ResourceNotExistsException(ResourceNotExistsException ex ,HttpServletRequest hr) {
		String msg = ex.getMessage();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
		String path = hr.getRequestURI();
		CustomExceptionResponce response = new CustomExceptionResponce(path, timeStamp, msg);
		return response;
		
	}
	
	
	
	
	
}
