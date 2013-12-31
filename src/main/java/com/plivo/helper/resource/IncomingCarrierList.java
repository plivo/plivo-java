package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.ListMeta;

public class IncomingCarrierList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<IncomingCarrier> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<IncomingCarrier> getList() {
		return list;
	}

}
