package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.base.Resource;
import com.plivo.helper.resource.meta.ListMeta;

public class CDRList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<CDR> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<CDR> getList() {
		return list;
	}

}
