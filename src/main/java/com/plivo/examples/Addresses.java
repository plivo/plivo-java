package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.address.Address;
import com.plivo.api.models.address.AddressCreateResponse;
import com.plivo.api.models.address.AddressUpdateResponse;
import com.plivo.api.models.address.NumberType;
import com.plivo.api.models.address.SalutationType;
import com.plivo.api.models.base.ListResponse;

public class Addresses {
	//Initialize the following authId and authToken with valid authId and authToken


	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createAddress();
	}

	// Example to create a address
	// Client is set by Plivo.init helper method in main()
	// The following params are mandatory
	private static void createAddress() {
		try {
			AddressCreateResponse response = Address.creator(
					"DK",
					NumberType.LOCAL,
					SalutationType.MR ,
					"firstName",
					"lastName",
					"addressLine1",
					"addressLine2",
					"City",
					"Region", 
					"PostalCode",
					"IN")
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to create a address with client
	// Client is set explicitly as shown below 
	// The following params are mandatory
	private static void createAddressWithClient() {
		try {
			AddressCreateResponse response = Address.creator(
					"DK",
					NumberType.LOCAL,
					SalutationType.MR ,
					"firstName",
					"lastName",
					"addressLine1",
					"addressLine2",
					"City",
					"Region", 
					"PostalCode",
					"IN")
					.client(client)
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a address
	// Client is set by Plivo.init helper method in main()
	private static void  getAddressInfo() {
		try {
			Address response = Address.getter("document_id").get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a address with client 
	// Client is set explicitly as shown below 
	private static void  getAddressInfoWithClient() {
		try {
			Address response = Address.getter("document_id").client(client).get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list  addresses
	// Client is set by Plivo.init helper method in main()
	private static void listAddresses() {
		try {
			ListResponse<Address> response = Address.lister().list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list  addresses with client
	// Client is set explicitly as shown below 
	private static void listAddressesWithClient() {
		try {
			ListResponse<Address> response = Address.lister().client(client).list();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update  address
	// Client is set by Plivo.init helper method in main()
	private static void	 updateAddressInfo() {
		try {
			AddressUpdateResponse response = Address.updater("documentId").
					streetCode("PK").update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update  address with client
	// Client is set explicitly as shown below 
	private static void	 updateAddressInfoWithClient() {
		try {
			AddressUpdateResponse response = Address.updater("documentId").
					streetCode("PK").client(client).update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete a  address
	// Client is set by Plivo.init helper method in main()
	private static void	 deleteAddressInfo() {
		try {
			Address.deleter("documentID").delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	//Example to delete a  address with client
	// Client is set by Plivo.init helper method in main()
	private static void	 deleteAddressInfoWithClient() {
		try {
			Address.deleter("documentID").client(client).delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
}
