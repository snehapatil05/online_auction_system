package com.oas.exception;

public final class UserAlreadyExistException extends RuntimeException {
	
	/*
	 * If user is already exists, this class catches exception.
	 */
	
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
