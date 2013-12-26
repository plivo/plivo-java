package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class ApplicationCreateResponse extends CreateResponse {
	@SerializedName("app_id")
    private String applicationID ;
    
	public ApplicationCreateResponse() {
		
	}
	
	public String getApplicationId() {
		return this.applicationID;
	}
}
