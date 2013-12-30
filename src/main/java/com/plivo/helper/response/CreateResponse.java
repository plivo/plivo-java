package com.plivo.helper.response;

public abstract class CreateResponse extends Response {
	@Override
	public boolean isSuccessful() {
		return serverCode == 201 && error == null;
	}
}
