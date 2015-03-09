package com.plivo.helper.api.response.number;

import com.google.gson.annotations.SerializedName;

public class NumberMeta {
    public String previous ;
    
    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public NumberMeta() {
        // empty
    }

	@Override
	public String toString() {
		return "NumberMeta [previous=" + previous + ", totalCount="
				+ totalCount + ", offset=" + offset + ", limit=" + limit
				+ ", next=" + next + "]";
	}
}
