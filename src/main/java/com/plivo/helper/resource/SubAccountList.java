package com.plivo.helper.resource;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.resource.meta.SubAccountMeta;

public class SubAccountList extends Resource {
	private SubAccountMeta meta ;

    @SerializedName("api_id")
    private String apiId ;
    
    @SerializedName("objects")
    private List<SubAccount> list;

	public SubAccountMeta getMeta() {
		return meta;
	}

	public String getApiId() {
		return apiId;
	}

	public List<SubAccount> getList() {
		return list;
	}
}
