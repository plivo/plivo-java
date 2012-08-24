package com.plivo.sdk.response.conference;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LiveConferenceList {
    public String error ;

    @SerializedName("api_id")
    public String apiID ;
    
    public List<String> conferences ;
    
    public LiveConferenceList() {
        // empty
    }
}
