package org.plivo.bridge.exception;

/**
 * Copyright (c) 2011 Plivo Inc. See LICENSE for details.
 *  2012-03-14
 * .
 */

import com.sun.jersey.api.client.UniformInterfaceException;

public class PlivoClientException extends Exception {

	private static final long serialVersionUID = 527743058445166802L;

	private int httpStatusCode;
	private String httpMessage;

	public PlivoClientException(UniformInterfaceException e) {
		this.setHttpStatusCode(e.getResponse().getStatus());
		this.setHttpMessage(e.getResponse().getEntity(String.class));
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getHttpMessage() {
		return httpMessage;
	}

	public void setHttpMessage(String httpMessage) {
		this.httpMessage = httpMessage;
	}
}
