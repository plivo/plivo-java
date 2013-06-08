package com.plivo.helper.api.response.response;

import com.google.gson.annotations.SerializedName;

public class Record {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String url;
    
    public String message;

    public String error;
    
    @SerializedName("api_id")
    public String api_id;
    
    public Record() {
        // empty
    }
}
