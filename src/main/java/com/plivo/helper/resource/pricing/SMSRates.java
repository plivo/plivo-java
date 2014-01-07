package com.plivo.helper.resource.pricing;

import com.google.gson.annotations.SerializedName;

public class SMSRates {
	@SerializedName("inbound")
	private Rate inbound;

	@SerializedName("outbound")
	private Rate outbound;

	public Rate getInbound() {
		return inbound;
	}

	public Rate getOutbound() {
		return outbound;
	}

}
