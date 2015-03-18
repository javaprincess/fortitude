package com.fox.it.erws.rest.api.service;

public final class ERWSException extends Exception {

	private static final long serialVersionUID = 1L;

	public ERWSException() {

	}

	public ERWSException(String message) {
		super(message);
	}

	public ERWSException(Throwable cause) {
		super(cause);
	}

	public ERWSException(String message, Throwable cause) {
		super(message, cause);
	}

	public ERWSException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
