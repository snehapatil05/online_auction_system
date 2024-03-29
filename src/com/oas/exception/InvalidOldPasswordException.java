package com.oas.exception;

public final class InvalidOldPasswordException extends RuntimeException {

	/*
	 * If password is invalid, this class catches exception.
	 */
	
    private static final long serialVersionUID = 1L;

    public InvalidOldPasswordException() {
        super();
    }

    public InvalidOldPasswordException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidOldPasswordException(final String message) {
        super(message);
    }

    public InvalidOldPasswordException(final Throwable cause) {
        super(cause);
    }

}
