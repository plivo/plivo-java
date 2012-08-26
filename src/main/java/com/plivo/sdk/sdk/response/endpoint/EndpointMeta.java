package com.plivo.sdk.response.endpoint;

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
}
