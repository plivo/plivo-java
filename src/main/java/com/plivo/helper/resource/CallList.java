package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CallList extends Resource {
	@SerializedName("api_id")
	public String apiId;

	@SerializedName("calls")
	public List<String> list;
}
