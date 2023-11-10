package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
	        StringBuilder errors = new StringBuilder();
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	                errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(", "));
	        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
	    }

}
