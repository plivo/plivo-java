package com.plivo.helper.resource.pricing;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class RatesPrefixes {
	private String rate;

	@SerializedName("prefix")
	private ArrayList<String> numberPrefixes;

	public String getRate() {
		return rate;
	}

	public ArrayList<String> getNumberPrefixes() {
		return numberPrefixes;
	}

}
