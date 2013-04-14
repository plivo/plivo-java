package com.plivo.helper.api.response.call;

import com.google.gson.annotations.SerializedName;

public class Call {
    public String message;
    
    @SerializedName("request_uuid")
    public String requestUUID ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error;
    
    public Call() {
        // empty
    }
}
