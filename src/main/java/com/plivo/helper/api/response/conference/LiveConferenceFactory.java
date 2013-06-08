package com.plivo.helper.api.response.conference;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LiveConferenceFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

    public String error ;

    @SerializedName("api_id")
    public String apiId ;
    
    public List<String> conferences ;
    
    public LiveConferenceFactory() {
        // empty
    }
}
