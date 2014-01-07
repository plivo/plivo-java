package com.plivo.helper.resource.pricing;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class OutboundVoicePricing {
	@SerializedName("local")
	private Rate local;

	@SerializedName("tollfree")
	private Rate tollfree;

	@SerializedName("ip")
	private Rate ip;

	@SerializedName("rates")
	private ArrayList<RatesPrefixes> prefixesRates;

	public Rate getLocal() {
		return local;
	}

	public Rate getTollfree() {
		return tollfree;
	}

	public Rate getIp() {
		return ip;
	}

	public ArrayList<RatesPrefixes> getPrefixesRates() {
		return prefixesRates;
	}

}
