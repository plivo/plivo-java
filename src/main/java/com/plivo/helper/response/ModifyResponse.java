package com.plivo.helper.response;

public class ModifyResponse extends Response {

	@Override
	public boolean isSuccessful() {
		return this.serverCode == 202 && this.error == null;
	}

}
