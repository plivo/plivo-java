package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.pricing.Pricing;

public class PricingExample {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		getPricingInfo();
	}

	// Example to get Pricing info
	// Client is set by Plivo.init helper method in main()
	// Pass the countryISO param to fetch pricing details
	private static void getPricingInfo() {
		try {
			Pricing response = Pricing.getter("CountryISO")
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to get Pricing info with client
	// Client is set explicitly as shown below 
	// Pass the countryISO param to fetch pricing details
	private static void getPricingInfoWithClient() {
		try {
			Pricing response = Pricing.getter("CountryISO")
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
}
