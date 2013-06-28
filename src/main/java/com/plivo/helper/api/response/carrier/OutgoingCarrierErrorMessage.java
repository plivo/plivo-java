package com.plivo.helper.api.response.carrier;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OutgoingCarrierErrorMessage {
    @SerializedName("name")
    public List<String> name ;
    
    @SerializedName("address")
    public List<String> address ;
    
    public String error;
    
    public OutgoingCarrierErrorMessage() {
        // empty
    }

}