package com.plivo.helper.api.response.account;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubAccountFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

    public SubAccountMeta meta ;

    public String error ;
    
    @SerializedName("api_id")
    public String apiId ;
    
    @SerializedName("objects")
    public List<SubAccount> subAccountList;
    
    public SubAccountFactory() {
        // empty
    }

	@Override
	public String toString() {
		return "SubAccountFactory [serverCode=" + serverCode + ", meta=" + meta
				+ ", error=" + error + ", apiId=" + apiId + ", subAccountList="
				+ subAccountList + "]";
	}
    
}
