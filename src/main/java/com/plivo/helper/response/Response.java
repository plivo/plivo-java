package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public abstract class Response {
	@SerializedName("server_code")
	protected Integer serverCode ;
	
	@SerializedName("error")
	protected String error;
	
	protected abstract boolean isSuccessful();
}
