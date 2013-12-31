package com.plivo.helper.response;

public class ModifyResponse extends Response {
	public boolean isSuccessful() {
		return this.getServerCode() == 202 && this.getError() == null;
	}
}
