package com.plivo.helper.api.response.carrier;

import com.google.gson.annotations.SerializedName;

public class OutgoingCarrierMeta {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public OutgoingCarrierMeta() {
        // empty
    }

	@Override
	public String toString() {
		return "OutgoingCarrierMeta [previous=" + previous + ", totalCount="
				+ totalCount + ", offset=" + offset + ", limit=" + limit
				+ ", next=" + next + "]";
	}

}