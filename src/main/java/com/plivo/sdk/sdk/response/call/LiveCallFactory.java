package com.plivo.sdk.response.call;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LiveCallFactory {
    @SerializedName("api_id")
    public String apiID ;
    
    @SerializedName("calls")
    public List<String> liveCallList ;
    
    public String error ;
    
    public LiveCallFactory() {
        // empty
    }
}
