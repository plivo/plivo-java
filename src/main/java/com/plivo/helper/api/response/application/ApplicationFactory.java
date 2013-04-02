package com.plivo.helper.api.response.application;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApplicationFactory {
    @SerializedName("objects")
    public List<Application> ApplicationList;
    
    @SerializedName("meta")
    public ApplicationMeta metaData;
    
    @SerializedName("api_id")
    public String apiID;
    
    public ApplicationFactory() {
            //empty
    }

}
