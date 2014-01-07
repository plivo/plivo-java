package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.base.Resource;

public class CallList extends Resource {
	@SerializedName("calls")
	private List<String> list;

	public List<String> getList() {
		return list;
	}

}
