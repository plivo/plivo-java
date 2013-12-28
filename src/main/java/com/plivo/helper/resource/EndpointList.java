package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.endpoint.Endpoint;
import com.plivo.helper.api.response.endpoint.EndpointMeta;

public class EndpointList extends Resource {
	private EndpointMeta meta;

	@SerializedName("objects")
	private List<Endpoint> list;

	public EndpointMeta getMeta() {
		return meta;
	}

	public List<Endpoint> getList() {
		return list;
	}

}
