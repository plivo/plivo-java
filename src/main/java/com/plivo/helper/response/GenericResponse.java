package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class GenericResponse {
	@SerializedName("server_code")
	private int serverCode;
	private Object error;
	private String message;
	@SerializedName("api_id")
	private String apiId;

	public int getServerCode() {
		return serverCode;
	}

	public String getError() {
		return error == null ? "" : error.toString();
	}

	public String getMessage() {
		return message == null ? "" : message;
	}

	public String getApiId() {
		return apiId;
	}

}
