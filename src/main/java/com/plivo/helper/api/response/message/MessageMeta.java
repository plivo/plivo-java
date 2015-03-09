package com.plivo.helper.api.response.message;

import com.google.gson.annotations.SerializedName;

public class MessageMeta {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public MessageMeta() {
        // empty
    }

	@Override
	public String toString() {
		return "MessageMeta [previous=" + previous + ", totalCount="
				+ totalCount + ", offset=" + offset + ", limit=" + limit
				+ ", next=" + next + "]";
	}

}
