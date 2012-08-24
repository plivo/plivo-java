package com.plivo.sdk.response.call;

import com.google.gson.annotations.SerializedName;

public class Call {
    public String message;
    
    @SerializedName("request_uuid")
    public String requestUUID ;
    
    @SerializedName("api_id")
    public String apiID ;
    
    public String error;
    
    public Call() {
        // empty
    }
}
