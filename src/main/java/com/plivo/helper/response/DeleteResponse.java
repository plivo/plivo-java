package com.plivo.helper.response;

public class DeleteResponse extends Response {
	public DeleteResponse() {
		super();
	}

	public boolean isSuccessful() {
		return this.getServerCode() == 204 && this.getError() == null;
	}
}
