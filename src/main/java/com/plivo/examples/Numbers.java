package com.plivo.examples;

import java.io.IOException;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import 	com.plivo.api.models.number.Number;
import com.plivo.api.models.number.NumberCreateResponse;
import com.plivo.api.models.number.NumberUpdateResponse;
import com.plivo.api.models.number.PhoneNumber;
import com.plivo.api.models.number.PhoneNumberCreateResponse;

public class Numbers {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		getNumberInfo();
	}

	// Example to get Number Info
	// Client is set by Plivo.init helper method in main()
	// Pass the number param to fetch the details
	private static void getNumberInfo() {
		try {
			Number response = Number.getter("number").get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get Number Info with client
	// Client is set explicitly as shown below 
	// Pass the number param to fetch the details
	private static void getNumberInfoWithClient() {
		try {
			Number response = Number.getter("number").client(client).get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update Number Info
	// Client is set by Plivo.init helper method in main()
	// Pass the number param to fetch the details
	private static void updateNumberInfo() {
		try {
			NumberUpdateResponse response = Number.updater("number")
					.alias("new_alias")
					.appId("new_app_id")
					.update();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get Number Info with client
	// Client is set explicitly as shown below 
	// Pass the number param to fetch the details
	private static void updateNumberInfoWithClient() {
		try {
			NumberUpdateResponse response = Number.updater("number")
					.alias("new_alias")
					.appId("new_app_id")
					.client(client)
					.update();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all numbers
	// Client is set by Plivo.init helper method in main()
	private static void listAllNumbers() {
		try {
			ListResponse<Number> response = Number.lister()
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to listall numbers with client
	// Client is set explicitly as shown below 
	private static void listAllNumbersWithClient() {
		try {
			ListResponse<Number> response = Number.lister()
					.limit(5)
					.offset(0)
					.client(client)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a number
	// Client is set by Plivo.init helper method in main()
	// Pass the number param to delete
	private static void deleteNumber() {
		try {
			Number.deleter("number").delete();
			System.out.println("Number deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a number with client
	// Client is set explicitly as shown below 
	// Pass the number param to delete
	private static void deleteNumberWithClient() {
		try {
			Number.deleter("number").client(client).delete();
			System.out.println("Number deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to create a number
	// Client is set by Plivo.init helper method in main()
	private static void createNumber() {
		try {

			NumberCreateResponse response = Number.creator(Collections.singletonList("number"),"carrier_id", "region")
					.create();
			System.out.println(response);

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to create a number with client
	// Client is set explicitly as shown below 
	private static void createNumberWithClient() {
		try {
			NumberCreateResponse response = Number.creator(Collections.singletonList("number"),"carrier_id", "region")
					.client(client)
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all phoneNumbers available for purchase
	// Client is set by Plivo.init helper method in main()
	private static void listAllPhoneNumbers() {
		try {
			ListResponse<PhoneNumber> response = PhoneNumber.lister("Countruy_code")
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example all phoneNumbers available for purchase with client
	// Client is set explicitly as shown below 
	private static void listAllPhoneNumbersWithClient() {
		try {
			ListResponse<PhoneNumber> response = PhoneNumber.lister("Countruy_code")
					.limit(5)
					.offset(0)
					.client(client)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to buy a phoneNumber
	// Client is set by Plivo.init helper method in main()
	//Pass the number and app_id of application to be assigned to the phone number

	private static void buyAPhoneNumber() {
		try {
			PhoneNumberCreateResponse response = PhoneNumber.creator("number").appId("appId").create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to buy a phoneNumber with client
	// Client is set explicitly as shown below 
	//Pass the number and app_id of application to be assigned to the phone number

	private static void buyAPhoneNumberWithClient() {
		try {
			PhoneNumberCreateResponse response = PhoneNumber.creator("number").appId("appId")
					.client(client)
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


}
