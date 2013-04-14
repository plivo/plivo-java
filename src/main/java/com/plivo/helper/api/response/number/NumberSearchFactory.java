package com.plivo.helper.api.response.number;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@Deprecated
public class NumberSearchFactory {
    public NumberMeta meta ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    public String error ;
    
    @SerializedName("objects")
    public List<Number> numberList ;
    
    public NumberSearchFactory() {
        // empty
    }
}
