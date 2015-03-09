package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

public class IncomingCarrierMeta {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public IncomingCarrierMeta() {
        // empty
    }

	@Override
	public String toString() {
		return "IncomingCarrierMeta [previous=" + previous + ", totalCount="
				+ totalCount + ", offset=" + offset + ", limit=" + limit
				+ ", next=" + next + "]";
	}

}