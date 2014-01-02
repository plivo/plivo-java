package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.ListMeta;

public class NumberList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<Number> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<Number> getList() {
		return list;
	}

}
