package com.agriculture.exception;

public class CropNotFoundException extends RuntimeException{
	
	public CropNotFoundException(String msg) {
	super(msg);
	}
}
