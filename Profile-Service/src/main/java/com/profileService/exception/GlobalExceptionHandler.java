package com.profileService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProfileNotFoundException.class)
	public ResponseEntity<String> profileNotFoundExceptionHandler(Exception e){
		String message = e.getMessage();
		return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
	}
}
