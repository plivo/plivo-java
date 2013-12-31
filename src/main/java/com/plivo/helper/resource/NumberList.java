package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.NumberMeta;

public class NumberList extends Resource {
	private NumberMeta meta;

	@SerializedName("objects")
	private List<Number> list;

	public NumberMeta getMeta() {
		return meta;
	}

	public List<Number> getList() {
		return list;
	}

}
