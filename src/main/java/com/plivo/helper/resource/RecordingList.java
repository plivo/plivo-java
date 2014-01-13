package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.resource.meta.ListMeta;

public class RecordingList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<Recording> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<Recording> getList() {
		return list;
	}

}
