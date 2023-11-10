package com.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cart.entity.User;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<Object> handleCartNotFoundException(CartNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(CropNotFoundException.class)
	public ResponseEntity<Object> handleCropNotFoundException(CropNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

	 @ExceptionHandler(QuantityNotExistsException.class)
	    public ResponseEntity<Object> handleQuantityNotExistsException(QuantityNotExistsException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
}
