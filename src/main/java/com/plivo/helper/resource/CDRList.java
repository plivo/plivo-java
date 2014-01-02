package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.ListMeta;

public class CDRList extends Resource {
	public ListMeta meta;

	@SerializedName("objects")
	public List<CDR> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<CDR> getList() {
		return list;
	}

}
