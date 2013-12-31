package com.plivo.helper.response;

public abstract class CreateResponse extends Response {
	public boolean isSuccessful() {
		return this.getServerCode() == 201 && this.getError() == null;
	}
}
