package com.oas.exception;

public class UserNotFoundException extends RuntimeException {
	
	/*
	 * If user is not found, this class catches exception.
	 */

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }
    
}
