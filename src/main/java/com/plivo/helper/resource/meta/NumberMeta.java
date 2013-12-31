package com.plivo.helper.resource.meta;

import com.google.gson.annotations.SerializedName;

public class NumberMeta {
	private String previous;

	@SerializedName("total_count")
	private Integer totalCount;

	private Integer offset;

	private Integer limit;

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
