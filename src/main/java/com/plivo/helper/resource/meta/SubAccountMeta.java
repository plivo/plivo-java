package com.plivo.helper.resource.meta;

import com.google.gson.annotations.SerializedName;

public class SubAccountMeta {
	private String previous;

	@SerializedName("total_count")
	private int totalCount;

	private int offset;

	private int limit;

	private String next;

	public String getPrevious() {
		return previous;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public String getNext() {
		return next;
	}

}
