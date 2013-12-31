package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.CDRMeta;

public class CDRList extends Resource {
	public CDRMeta meta;

	@SerializedName("objects")
	public List<CDR> list;

	public CDRMeta getMeta() {
		return meta;
	}

	public List<CDR> getList() {
		return list;
	}

}
