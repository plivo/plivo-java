package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.ApplicationMeta;

public class ApplicationList extends Resource {
	@SerializedName("objects")
	private List<Application> list;

	@SerializedName("meta")
	private ApplicationMeta meta;

	@SerializedName("api_id")
	private String apiId;

	public List<Application> getList() {
		return list;
	}

	public ApplicationMeta getMeta() {
		return meta;
	}

	public String getApiId() {
		return apiId;
	}

}
