package com.avokey.orm.exception;

public class OrmException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public OrmException(String message) {
		super(message);
	}
}
