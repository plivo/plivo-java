package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CallList extends Resource {
	@SerializedName("calls")
	private List<String> list;

	public List<String> getList() {
		return list;
	}

}
