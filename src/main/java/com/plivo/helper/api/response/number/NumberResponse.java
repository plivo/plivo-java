package com.plivo.helper.api.response.number;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class NumberResponse {
    @SerializedName("numbers")
    public List<NumberStatus> numberStatusList ;
    
    public String status ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId;
    
    public NumberResponse() {
        // empty
    }
}
