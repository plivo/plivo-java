package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.application.Application;
import com.plivo.api.models.application.ApplicationCreateResponse;
import com.plivo.api.models.application.ApplicationUpdateResponse;
import com.plivo.api.models.base.ListResponse;

public class Applications {
	
//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createApplication();
	}

	// Example to create a application
	// Client is set by Plivo.init helper method in main()
	// Application name and answer url are mandatory params

	private static void createApplication() {
		try {
			ApplicationCreateResponse response = Application.creator("Test Application")
					.answerUrl("http://answerurl")
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to create a application with client
	// client is set explicitly as shown below 
	// Application name and answer url are mandatory params

	private static void createApplicationWithClient() {
		try {
			ApplicationCreateResponse response = Application.creator("Test Application")
					.answerUrl("http://answerurl")
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a application
	// Client is set by Plivo.init helper method in main()
	// Pass the app_id of the application
	private static void getApplicationInfo() {
		try {
			Application response = Application.getter("997752XXXJJDXXX265")
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to get details of a application with client 
	// client is set explicitly as shown below 
	// Pass the app_id of the application
	private static void getApplicationInfoWithClient() {
		try {
			Application response = Application.getter("997752XXXJJDXXX265")
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a application
	// Client is set by Plivo.init helper method in main()
	// Pass the app_id of the application
	private static void updateApplicationInfo() {
		try {
			ApplicationUpdateResponse response = Application.updater("997752XXXJJDXXX265")
					.answerUrl("http://updatedanswerurl")
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a application with client
	// client is set explicitly as shown below 
	// Pass the app_id of the application
	private static void updateApplicationInfoWithClient() {
		try {
			ApplicationUpdateResponse response = Application.updater("997752XXXJJDXXX265")
					.answerUrl("http://updatedanswerurl")
					.client(client)
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	//Example to delete a application with client
	// Client is set by Plivo.init helper method in main()
	// Pass the app_id of the application
	private static void deleteApplication() {
		try {
			Application.deleter("997752XXXJJDXXX265").delete();
			System.out.println("Application deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// Example to delete a application with client
	// client is set explicitly as shown below 
	// Pass the app_id of the application
	private static void deleteApplicationWithClient() {
		try {
			Application.deleter("997752XXXJJDXXX265").client(client).delete();
			System.out.println("Application deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// Example to list all applications
	// Client is set by Plivo.init helper method in main()
	private static void listAllApplications() {
	  try {
      ListResponse<Application> response = Application.lister()
					.limit(5)
          .offset(0)
          .list();
    
      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
	}
	
	
	// Example to list all applications with client
	// client is set explicitly as shown below 
	// Pass the app_id of the application
	private static void listAllApplicationsWithClient() {
	  try {
      ListResponse<Application> response = Application.lister()
      		.client(client)
					.limit(5)
          .offset(0)
          .list();
    
      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
	}

}
