package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class EndpointCreateResponse extends CreateResponse {
	private String username;
	private String alias;

	@SerializedName("endpoint_id")
	private String endpointId;

	public String getUsername() {
		return username;
	}

	public String getAlias() {
		return alias;
	}

	public String getEndpointId() {
		return endpointId;
	}

}
