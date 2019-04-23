package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.endpoint.Endpoint;
import com.plivo.api.models.endpoint.EndpointCreateResponse;
import com.plivo.api.models.endpoint.EndpointUpdateResponse;

public class Endpoints {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createEndpoint();
	}

	// Example to create a endpoint
	// Client is set by Plivo.init helper method in main()
	// username, password and alias for the endpoint are mandatory params
	private static void createEndpoint() {
		try {
			EndpointCreateResponse response = Endpoint.creator("testusername", "testpassword", "Test Account")
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to create a endpoint with client
	// Client is set explicitly as shown below 
	// username, password and alias for the endpoint are mandatory params
	private static void createEndpointWithClient() {
		try {
			EndpointCreateResponse response = Endpoint.creator("testusername", "testpassword", "Test Account")
					.client(client)
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}



	// Example to get  endpoint details
	// Client is set by Plivo.init helper method in main()
	// Pass endpointID to fetch the details
	private static void getEndpoint() {
		try {
			Endpoint response = Endpoint.getter("endpoint_id")
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get a endpoint details with client
	// Client is set explicitly as shown below 
	//Pass endpointID to fetch the details

	private static void getEndpointWithClient() {
		try {
			Endpoint response = Endpoint.getter("endpoint_id")
					.client(client)
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to update  endpoint details
	// Client is set by Plivo.init helper method in main()
	// Pass endpointID to update the endpoint
	private static void updateEndpoint() {
		try {
			EndpointUpdateResponse response = Endpoint.updater("endpoint_id")
					.alias("Updated Endpoint Alias")
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a endpoint details with client
	// Client is set explicitly as shown below 
	// Pass endpointID to update the endpoint

	private static void updateEndpointWithClient() {
		try {
			EndpointUpdateResponse response = Endpoint.updater("endpoint_id")
					.alias("Updated Endpoint Alias")
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all endpoints
	// Client is set by Plivo.init helper method in main()
	private static void listAllEndpoints() {
		try {
			ListResponse<Endpoint> response = Endpoint.lister()
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all endpoints
	// Client is set explicitly as shown below 

	private static void listAllEndpointsWithClient() {
		try {
			ListResponse<Endpoint> response = Endpoint.lister()
					.client(client)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a endpoint
	// Client is set by Plivo.init helper method in main()
	// Pass endpointID to delete
	private static void deleteAEndpoint() {
		try {
			Endpoint.deleter("endpoint_id")
			.delete();

			System.out.println("Deleted endpoint successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete a endpoint with client
	// Client is set explicitly as shown below 
	// Pass endpointID to delete

	private static void deleteAEndpointWithClient() {
		try {
			Endpoint.deleter("endpoint_id")
			.client(client)
			.delete();

			System.out.println("Deleted endpoint successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

}
