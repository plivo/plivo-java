/**
 * Plivo API Exception
 */
package com.plivo.helper.exception;

public class APIException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String message;
	private final int serverCode;
	private final String error;

	public APIException(int serverCode, String message, String error) {
		super();
		this.serverCode = serverCode;
		this.message = message;
		this.error = error;
	}

	@Override
	public String toString() {
		return "Plivo API Exception. Server Code = " + serverCode
				+ ".message = " + message + ".error = " + error;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public int getServerCode() {
		return serverCode;
	}

	public String getError() {
		return error;
	}

}
