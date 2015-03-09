package com.plivo.helper.api.response.call;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CDRFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

    public CDRMeta meta ;
    
    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("objects")
    public List<CDR> cdrList ;
    
    public CDRFactory() {
    	// empty
    }

	@Override
	public String toString() {
		return "CDRFactory [serverCode=" + serverCode + ", meta=" + meta
				+ ", error=" + error + ", apiId=" + apiId + ", cdrList="
				+ cdrList + "]";
	}
    
}
