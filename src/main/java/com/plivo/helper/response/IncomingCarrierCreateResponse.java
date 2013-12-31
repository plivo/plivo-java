package com.plivo.helper.response;

import com.google.gson.annotations.SerializedName;

public class IncomingCarrierCreateResponse extends CreateResponse {
	@SerializedName("carrier_id")
	private String carrierId;

	public String getCarrierId() {
		return carrierId;
	}

}
