package com.order.exception;

@SuppressWarnings("serial")
public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException( String msg) {
        super(msg);
    }
}