package com.plivo.examples;

import java.io.IOException;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;

public class Messages {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createMessage();
	}

	// Example to create a Message
	// Client is set by Plivo.init helper method in main()
	// The following params that are passed are mandatory
	private static void createMessage() {
		try {
			MessageCreateResponse response = Message.creator("from_number", Collections.singletonList("to_number"), "Test Message")
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to create a Message with client
	// Client is set explicitly as shown below 
	// The following params that are passed are mandatory
	private static void createMessageWithClient() {
		try {
			MessageCreateResponse response = Message.creator("from_number", Collections.singletonList("to_number"), "Test Message")
					.client(client)
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get Message info
	// Client is set by Plivo.init helper method in main()
	// Pass message_uuid to get the info
	private static void getMessageInfo() {
		try {
			Message response = Message.getter("message_uuid")
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to get Message info with client
	// Client is set explicitly as shown below 
	// Pass message_uuid to get the info
	private static void getMessageInfoWithClient() {
		try {
			Message response = Message.getter("message_uuid")
					.client(client)
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all messages
	// Client is set by Plivo.init helper method in main()
	private static void listAllMessages() {
		try {
			ListResponse<Message> response = Message.lister()
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all messages with client
	// Client is set explicitly as shown below 
	private static void listAllMessagesWithClient() {
		try {
			ListResponse<Message> response = Message.lister()
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
