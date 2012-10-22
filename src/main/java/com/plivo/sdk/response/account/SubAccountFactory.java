package com.plivo.sdk.response.account;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubAccountFactory {
    public SubAccountMeta meta ;

    public String error ;
    
    @SerializedName("api_id")
    public String apiID ;
    
    @SerializedName("objects")
    public List<SubAccount> SubAccountList;
    
    public SubAccountFactory() {
        // empty
    }
}
