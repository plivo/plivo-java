package com.plivo.helper.api.response.carrier;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OutgoingCarrierRoutingErrorMessage {
    @SerializedName("prefixes")
    public List<String> prefixes ;
    
    @SerializedName("priority")
    public List<String> priority ;
    
    @SerializedName("outgoing_carrier")
    public List<String> outgoing_carrier ;
    
    public String error;
    
    public OutgoingCarrierRoutingErrorMessage() {
        // empty
    }

}