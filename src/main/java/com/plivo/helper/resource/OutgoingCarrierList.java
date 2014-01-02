package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.ListMeta;

public class OutgoingCarrierList extends Resource {
	private ListMeta meta;

	@SerializedName("objects")
	private List<OutgoingCarrier> list;

	public ListMeta getMeta() {
		return meta;
	}

	public List<OutgoingCarrier> getList() {
		return list;
	}

}
