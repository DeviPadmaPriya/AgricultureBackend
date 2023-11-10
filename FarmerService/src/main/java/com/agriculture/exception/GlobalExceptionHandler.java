package com.agriculture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CropNotFoundException.class)
	public ResponseEntity<Object> handleStudentAlreadyExistsException(CropNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(),  HttpStatus.NOT_FOUND);
    }

}
