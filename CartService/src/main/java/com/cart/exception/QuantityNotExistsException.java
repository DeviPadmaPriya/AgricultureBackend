package com.cart.exception;

public class QuantityNotExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public QuantityNotExistsException(String msg) {
		super(msg);
	}

}
