package com.plivo.helper.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RentNumberGroupResponse extends Response {
	@SerializedName("numbers")
	private List<NumberStatus> numberStatusList;

	private String status;

	public List<NumberStatus> getNumberStatusList() {
		return numberStatusList;
	}

	public String getStatus() {
		return status;
	}
}
