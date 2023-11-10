package com.agriculture.exception;
@SuppressWarnings("serial")
public class CropAlreadyFoundException extends RuntimeException {

	
	public CropAlreadyFoundException(String message) {
		super(message);
	}
}
