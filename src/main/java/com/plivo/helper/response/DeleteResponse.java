package com.plivo.helper.response;

public class DeleteResponse extends Response{
	public DeleteResponse() {
		super();
	}
	
	@Override
	public boolean isSuccessful() {
		return this.serverCode == 204 && error == null;
	}
}
