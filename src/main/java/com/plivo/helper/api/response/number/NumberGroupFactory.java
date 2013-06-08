package com.plivo.helper.api.response.number;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class NumberGroupFactory {
	@SerializedName("server_code")
	public Integer serverCode ;

	public NumberMeta meta ;
	
	@SerializedName("objects")
	public List<NumberGroup> groupList ;
	
	@SerializedName("api_id")
	public String apiId ;
	
	public String error ;
	
	public NumberGroupFactory() {
		// empty
	}
}
