package com.cart.exception;

import org.springframework.http.HttpStatus;

public class CropNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CropNotFoundException(String msg) {
	super(msg);
	}

	public CropNotFoundException() {
		super();
	}



}
