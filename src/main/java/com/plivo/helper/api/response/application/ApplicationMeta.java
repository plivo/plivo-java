package com.plivo.helper.api.response.application;

public class ApplicationMeta {
    public String previous;
    public Integer total_count;
    public Integer offset;
    public Integer limit;
    public String next;
    
    public ApplicationMeta() {
            // empty
    }

	@Override
	public String toString() {
		return "ApplicationMeta [previous=" + previous + ", total_count="
				+ total_count + ", offset=" + offset + ", limit=" + limit
				+ ", next=" + next + "]";
	}
    
}
