package com.plivo.helper.api.response.pricing;

import com.google.gson.annotations.SerializedName;
import com.plivo.helper.api.response.pricing.LocalNumberRental;
import com.plivo.helper.api.response.pricing.TollFreeNumberRental;

public class PhoneNumbers {
	@SerializedName("local")
	public LocalNumberRental localMonthlyRental ;

	@SerializedName("tollfree")
	public TollFreeNumberRental tollfreeMonthlyRental ;
	
	public PhoneNumbers() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PhoneNumbers [localMonthlyRental=" + localMonthlyRental
				+ ", tollfreeMonthlyRental=" + tollfreeMonthlyRental + "]";
	}
}
