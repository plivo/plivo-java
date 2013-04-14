package com.plivo.helper.api.response.application;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApplicationFactory {
    @SerializedName("objects")
    public List<Application> applicationList ;
    
    @SerializedName("meta")
    public ApplicationMeta meta ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error ;
    
    public ApplicationFactory() {
            //empty
    }

}
