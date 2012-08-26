package com.plivo.sdk.response.message;

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

}
