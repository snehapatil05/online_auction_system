package com.oas.exception;

public class InsertFailedException extends Exception {
	/**
	 * If record not inserted this class catches exception.
	 */
	private static final long serialVersionUID = 1L;

	public InsertFailedException() {
	}

	public InsertFailedException(String message) {
		super(message);
	}
}
