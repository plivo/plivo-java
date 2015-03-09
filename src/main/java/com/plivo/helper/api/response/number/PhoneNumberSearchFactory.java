package com.plivo.helper.api.response.number;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PhoneNumberSearchFactory {

    public NumberMeta meta;
    
    @SerializedName("api_id")
    public String apiId;
    
    public String error;
    
    @SerializedName("objects")
    public List<PhoneNumber> numberList;
    
    public PhoneNumberSearchFactory() {
        // empty
    }

	@Override
	public String toString() {
		return "PhoneNumberSearchFactory [meta=" + meta + ", apiId=" + apiId
				+ ", error=" + error + ", numberList=" + numberList + "]";
	}
}
