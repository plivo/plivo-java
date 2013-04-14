package com.plivo.helper.api.response.response;

import com.google.gson.annotations.SerializedName;

public class GenericResponse {
    public String message ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public GenericResponse() {
        // empty
    }
}
