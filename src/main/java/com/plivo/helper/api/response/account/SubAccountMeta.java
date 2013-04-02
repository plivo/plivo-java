package com.plivo.helper.api.response.account;

import com.google.gson.annotations.SerializedName;

public class SubAccountMeta {
    public String previous ;

    @SerializedName("total_count")
    public Integer totalCount ;
    
    public Integer offset ;
    
    public Integer limit ;
    
    public String next ;
    
    public SubAccountMeta() {
        // empty
    }
}
