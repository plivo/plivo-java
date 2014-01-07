package com.plivo.helper.exception;

public class InvalidAuthException extends Exception {
	private static final long serialVersionUID = 1L;
	private final int serverCode;
	private final String message;

	public InvalidAuthException(int serverCode, String message) {
		super();
		this.serverCode = serverCode;
		this.message = message;
	}

	public int getServerCode() {
		return serverCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
