package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public abstract class Response {
	@SerializedName("server_code")
	protected Integer serverCode;

	@SerializedName("error")
	protected String error;

	protected String message;

	@SerializedName("api_id")
	protected String apiId;

	protected abstract boolean isSuccessful();

	public Integer getServerCode() {
		return serverCode;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getApiId() {
		return apiId;
	}

}
