package com.plivo.sdk.response.number;

import com.google.gson.annotations.SerializedName;

public class NumberSearchFactory {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public NumberSearchFactory() {
        // empty
    }
}
