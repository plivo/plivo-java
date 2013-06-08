package com.plivo.helper.api.response.call;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LiveCallFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("calls")
    public List<String> liveCallList ;
    
    public String error ;
    
    public LiveCallFactory() {
        // empty
    }
}
