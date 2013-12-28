package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public abstract class CreateResponse extends Response {
	@SerializedName("api_id")
	private String apiID;

	@SerializedName("message")
	private String message;

	@Override
	public boolean isSuccessful() {
		return serverCode == 201 && error == null;
	}

	public Integer getServerCode() {
		return serverCode;
	}

	public String getApiID() {
		return apiID;
	}

	public String getMessage() {
		return message;
	}

}
