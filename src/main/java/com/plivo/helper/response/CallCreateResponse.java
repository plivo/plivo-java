package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class CallCreateResponse extends CreateResponse {
	@SerializedName("request_uuid")
	private String requestUUID;

	public String getRequestUUID() {
		return requestUUID;
	}

}
