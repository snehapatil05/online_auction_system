package com.oas.exception;

public class DataAccessException extends Exception {

	/*
	 * Exception made to catch errors when database data is not being accessed properly 
	 */
	
	private static final long serialVersionUID = 1L;
	public DataAccessException() {
	}
	public DataAccessException(String message) {
		super(message);
	}
}
