package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.resource.meta.ListMeta;

public class AvailableNumberGroupList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<AvailableNumberGroup> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<AvailableNumberGroup> getList() {
		return list;
	}

}
