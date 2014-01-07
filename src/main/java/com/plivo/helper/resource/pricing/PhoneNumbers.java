package com.plivo.helper.resource.pricing;

import com.google.gson.annotations.SerializedName;

public class PhoneNumbers {
	@SerializedName("local")
	private Rate local;

	@SerializedName("tollfree")
	private Rate tollfree;

	public Rate getLocal() {
		return local;
	}

	public Rate getTollfree() {
		return tollfree;
	}

}
