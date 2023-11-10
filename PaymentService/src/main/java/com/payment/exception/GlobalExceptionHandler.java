package com.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler({UserNotFoundException.class,  OrderNotFoundException.class})
	    public ResponseEntity<CustomErrorResponse> handleNotFoundExceptions(RuntimeException ex) {
	        CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	
//	@ExceptionHandler(UserNotFoundException.class)
//	public ResponseEntity<CustomErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
//	    CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getMessage());
//	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	}
//	
//	
//	@SuppressWarnings("unused")
//	@ExceptionHandler(CropNotFoundException.class)
//	public ResponseEntity<CustomErrorResponse> handleCropNotFoundException(CropNotFoundException ex) {
//	    CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getMessage());
//	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	}
//	
//	@SuppressWarnings("unused")
//	@ExceptionHandler(CartNotFoundException.class)
//	public ResponseEntity<CustomErrorResponse> handleCartNotFoundException(CartNotFoundException ex) {
//	    CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getMessage());
//	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	}
}
