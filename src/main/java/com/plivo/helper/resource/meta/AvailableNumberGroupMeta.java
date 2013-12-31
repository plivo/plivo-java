package com.plivo.helper.resource.meta;

import com.google.gson.annotations.SerializedName;

public class AvailableNumberGroupMeta {
	private String previous;

	@SerializedName("total_count")
	private int totalCount;

	private int offset;

	private int limit;

	private String next;

	public String getPrevious() {
		return previous;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getOffset() {
		return offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public String getNext() {
		return next;
	}

}
