package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class SubAccountCreateResponse extends CreateResponse {
	@SerializedName("auth_id")
	private String authId;

	public String getAuthId() {
		return authId;
	}
}
