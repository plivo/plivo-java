package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.application.Application;
import com.plivo.helper.api.response.application.ApplicationMeta;

public class ApplicationList {
	@SerializedName("server_code")
	public Integer serverCode ;

   @SerializedName("objects")
    public List<Application> applicationList ;
    
    @SerializedName("meta")
    public ApplicationMeta meta ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error ;
    
    public ApplicationList() {
    	
    }
}
