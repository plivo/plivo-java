package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.resource.meta.ListMeta;

public class EndpointList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<Endpoint> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<Endpoint> getList() {
		return list;
	}

}
