package com.plivo.helper.resource.meta;

public class ListMeta {
	private String previous;
	private int total_count;
	private int offset;
	private int limit;
	private String next;

	public String getPrevious() {
		return previous;
	}

	public int getTotalCount() {
		return total_count;
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
