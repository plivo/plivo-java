package com.plivo.helper.resource.pricing;

import com.google.gson.annotations.SerializedName;

public class InboundVoicePricing {
	@SerializedName("local")
	private Rate local;

	@SerializedName("tollfree")
	private Rate tollfree;

	@SerializedName("ip")
	private Rate ip;

	public Rate getLocal() {
		return local;
	}

	public Rate getTollfree() {
		return tollfree;
	}

	public Rate getIp() {
		return ip;
	}

}
