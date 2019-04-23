package com.plivo.examples;

import java.io.IOException;
import java.time.LocalDate;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.identity.Identity;
import com.plivo.api.models.identity.IdentityCreateResponse;
import com.plivo.api.models.identity.IdentityUpdateResponse;

public class Identities {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createIdentity();
	}

	// Example to create a Identity
	// Client is set by Plivo.init helper method in main()
	// The following params that are passed are mandatory
	private static void createIdentity() {
		try {

			IdentityCreateResponse response = Identity.creator(
					"IN",
					"MR" ,
					"firstName",
					"lastName",
					"birthPlace",
					LocalDate.of(1990,11,12),
					"nationality",
					"idNationality",
					LocalDate.of(2000,12,23),
					"businessName",
					"idType",
					"idNumber",
					"addressLine1",
					"addressLine2",
					"City",
					"Region", 
					"PostalCode")
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}



	// Example to create a Identity with client
	// Client is set explicitly as shown below 
	// The following params that are passed are mandatory
	private static void createIdentityWithClient() {
		try {

			IdentityCreateResponse response = Identity.creator(
					"IN",
					"MR" ,
					"firstName",
					"lastName",
					"birthPlace",
					LocalDate.of(1990,11,12),
					"nationality",
					"idNationality",
					LocalDate.of(2000,12,23),
					"businessName",
					"idType",
					"idNumber",
					"addressLine1",
					"addressLine2",
					"City",
					"Region", 
					"PostalCode")
					.client(client)
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all identities
	// Client is set by Plivo.init helper method in main()
	private static void listAllIdentites() {
		try {
			ListResponse<Identity> response = Identity.lister()
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all identities with client
	// Client is set explicitly as shown below 
	private static void listAllIdentitesWithClient() {
		try {
			ListResponse<Identity> response = Identity.lister()
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a identity
	// Client is set by Plivo.init helper method in main()
	// Pass the documentId of the identity
	private static void getIdentityInfo() {
		try {
			Identity response = Identity.getter("document_id")
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a identity with client
	// Client is set explicitly as shown below 
	// Pass the documentId of the identity
	private static void getIdentityInfoWithClient() {
		try {
			Identity response = Identity.getter("document_id")
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a identity
	// Client is set by Plivo.init helper method in main()
	// Pass the document_id of the identity
	private static void updateIdentityInfo() {
		try {
			IdentityUpdateResponse response = Identity.updater("document_id")
					.city("newCity")
					.postalCode("newPostalCode")
					.countryIso("newCountryISO")
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a identity with client
	// Client is set explicitly as shown below 
	// Pass the document_id of the identity
	private static void updateIdentityInfowithClient() {
		try {
			IdentityUpdateResponse response = Identity.updater("document_id")
					.city("newCity")
					.postalCode("newPostalCode")
					.countryIso("newCountryISO")
					.client(client)
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete a identity
	// Client is set by Plivo.init helper method in main()
	// Pass the app_id of the identity
	private static void deleteIdentity() {
		try {
			Identity.deleter("document_id").delete();
			System.out.println("Identity deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a identity with client
	// Client is set explicitly as shown below 
	// Pass the app_id of the identity
	private static void deleteIdentityWithClient() {
		try {
			Identity.deleter("document_id").client(client).delete();
			System.out.println("Identity deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


}
