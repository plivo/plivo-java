package com.plivo.helper.api.response.endpoint;

import com.google.gson.annotations.SerializedName;

public class EndpointMeta {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;

    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public EndpointMeta() {
        // empty
    }

	@Override
	public String toString() {
		return "EndpointMeta [previous=" + previous + ", totalCount="
				+ totalCount + ", offset=" + offset + ", limit=" + limit
				+ ", next=" + next + "]";
	}
}
