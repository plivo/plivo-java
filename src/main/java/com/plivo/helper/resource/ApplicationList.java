package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.ListMeta;

public class ApplicationList extends Resource {
	@SerializedName("objects")
	private List<Application> list;

	@SerializedName("meta")
	private ListMeta meta;

	public List<Application> getList() {
		return list;
	}

	public ListMeta getMeta() {
		return meta;
	}
}
