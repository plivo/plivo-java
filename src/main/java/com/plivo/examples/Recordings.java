package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.identity.Identity;
import com.plivo.api.models.pricing.Pricing;
import com.plivo.api.models.recording.Recording;

public class Recordings {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		getRecordingInfo();
	}

	// Example to get recording info
	// Client is set by Plivo.init helper method in main()
	// Pass the recordingID to get the details
	private static void getRecordingInfo() {
		try {
			Recording response = Recording.getter("recordingId")
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to get recording info with client
	// Client is set explicitly as shown below 
	// Pass the recordingID to get the details
	private static void getRecordingInfoWithClient() {
		try {
			Recording response = Recording.getter("recordingId")
					.client(client)
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a recording 
	// Client is set by Plivo.init helper method in main()
	// Pass the recordingID to delete
	private static void deleteRecordingInfo() {
		try {
			Recording.deleter("recordingId").delete();
			System.out.println("Recording deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a recording with client
	// Client is set explicitly as shown below 
	// Pass the recordingID to delete
	private static void deleteRecordingInfoWithClient() {
		try {
			Recording.deleter("recordingId").client(client).delete();
			System.out.println("Recording deleted successfully");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all recordings 
	// Client is set by Plivo.init helper method in main()
	private static void listRecordings() {
		try {
			ListResponse<Recording> response = Recording.lister()
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}


	// Example to list all recordings with client
	// Client is set explicitly as shown below 
	private static void listRecordingsWithClient() {
		try {
			ListResponse<Recording> response = Recording.lister()
					.limit(5)
					.offset(0)
					.client(client)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
}
