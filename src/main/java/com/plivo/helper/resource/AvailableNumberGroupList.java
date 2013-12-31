package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.AvailableNumberGroupMeta;

public class AvailableNumberGroupList extends Resource {
	private AvailableNumberGroupMeta meta;

	@SerializedName("objects")
	private List<AvailableNumberGroup> list;

	public AvailableNumberGroupMeta getMeta() {
		return meta;
	}

	public List<AvailableNumberGroup> getList() {
		return list;
	}

}
