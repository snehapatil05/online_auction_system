package com.oas.exception;

public class DBException extends Exception{
	private static final long serialVersionUID = 1L;
	public DBException() {
	}
	public DBException(String message) {
		super(message);
	}

}
