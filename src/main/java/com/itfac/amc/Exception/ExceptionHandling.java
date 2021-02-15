package com.itfac.amc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class ExceptionHandling extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Object> myExceptionHandler(Exception ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex);
	}
}
