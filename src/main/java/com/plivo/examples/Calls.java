package com.plivo.examples;

import java.io.IOException;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.CallCreateResponse;
import com.plivo.api.models.call.CallDirection;
import com.plivo.api.models.call.CallUpdateResponse;
import com.plivo.api.models.call.LegSpecifier;
import com.plivo.api.models.call.LiveCall;
import com.plivo.api.models.call.LiveCallListResponse;
import com.plivo.api.models.call.QueuedCall;
import com.plivo.api.models.call.QueuedCallListResponse;
import com.plivo.api.models.call.actions.CallDtmfCreateResponse;
import com.plivo.api.models.call.actions.CallPlayCreateResponse;
import com.plivo.api.models.call.actions.CallRecordCreateResponse;
import com.plivo.api.models.call.actions.CallSpeakCreateResponse;

public class Calls {
	
//Initialize the following authId and authToken with valid authId and authToken
	
	
	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		createCall();
	}

	// Example to create a call
	// Client is set by Plivo.init helper method in main()
	// from, to and answer_url are mandatory params

	private static void createCall() {
		try {
			CallCreateResponse response = Call.creator("from_number", Collections.singletonList("to_number"), "http://answerurl")
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to create a call with client
	// Client is set explicitly as shown below 
	// from, to and answer_url are mandatory params

	private static void createCallWithClient() {
		try {
			CallCreateResponse response = Call.creator("from_number", Collections.singletonList("to_number"), "http://answerurl")
					.client(client)
					.create();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to get call details
	// Client is set by Plivo.init helper method in main()
	// pass call_id of corresponding call 

	private static void getCallDetails() {
		try {
			Call response = Call.getter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	//Example to get call details with client
	// Client is set explicitly as shown below 
	// pass call_id of corresponding call 

	private static void getCallDetailsWithClient() {
		try {
			Call response = Call.getter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a call
	// Client is set by Plivo.init helper method in main()
	// pass call_id of corresponding call 

	private static void updateCallDetails() {
		try {
			CallUpdateResponse response = Call.updater("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.legs(LegSpecifier.ALEG)
					.alegUrl("https://example.com/connect")
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to update a call with client
	// Client is set explicitly as shown below 
	// pass call_id of corresponding call 

	private static void updateDetailsWithClient() {
		try {	
			CallUpdateResponse response = Call.updater("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.legs(LegSpecifier.ALEG)
					.alegUrl("https://example.com/connect")
					.client(client)
					.update();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete a call
	// Client is set by Plivo.init helper method in main()
	// pass call_id of corresponding call 

	private static void deleteACall() {
		try {
			Call.deleter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.delete();

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to  update a call with client
	// Client is set explicitly as shown below 
	// pass call_id of corresponding call 

	private static void deleteACallWithClient() {
		try {
			Call.deleter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.client(client)
			.delete();

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	//Example to list all calls
	// Client is set by Plivo.init helper method in main()

	private static void listAllCalls() {
		try {
			ListResponse<Call> response  = Call.lister()
					.limit(5)
					.offset(0)
					.list();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all calls with client
	// Client is set explicitly as shown below 

	private static void listAllCallsWithClient() {
		try {
			ListResponse<Call> response  = Call.lister()
					.client(client)
					.limit(5)
					.offset(0)
					.list();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a live call
	// Client is set by Plivo.init helper method in main()
	// pass LiveCallID of corresponding call 

	private static void getLiveCallInfo() {
		try {
			LiveCall response = LiveCall.getter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.get();
			System.out.println(response);

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a live call  with client
	// Client is set explicitly as shown below 
	// pass LiveCallID of corresponding call 

	private static void getLiveCallInfoWithClient() {
		try {
			LiveCall response = LiveCall.getter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.client(client)
					.get();
			System.out.println(response);

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all Live calls
	// Client is set by Plivo.init helper method in main()

	private static void listAllLiveCalls() {
		try {
			LiveCallListResponse response  = LiveCall.listGetter()
					.callDirection(CallDirection.INBOUND)
					.fromNumber("from_number")
					.toNumber("to_number")
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all Live calls with client
	// Client is set explicitly as shown below 

	private static void listAllLiveCallsWithClient() {
		try {
			LiveCallListResponse response  = LiveCall.listGetter()
					.callDirection(CallDirection.INBOUND)
					.fromNumber("from_number")
					.toNumber("to_number")
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	//Example to get details of a QueuedCall
	// Client is set by Plivo.init helper method in main()
	// pass CallID of corresponding call 

	private static void getQueuedCallInfo() {
		try {
			QueuedCall response = QueuedCall.getter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a queued call  with client
	// Client is set explicitly as shown below 
	// pass callId of corresponding call 

	private static void getQueuedCallInfoWithClient() {
		try {
			QueuedCall response = QueuedCall.getter("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.client(client)
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all queued calls
	// Client is set by Plivo.init helper method in main()

	private static void listAllQueuedCalls() {
		try {
			QueuedCallListResponse response = QueuedCall.listGetter()
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to list all Queued calls with client
	// Client is set explicitly as shown below 

	private static void listAllQueuedCallsWithClient() {
		try {
			QueuedCallListResponse response = QueuedCall.listGetter()
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to record a call
	// Client is set by Plivo.init helper method in main()
	// Pass call_id of the call
	private static void recordACall() {
		try {
			CallRecordCreateResponse response = Call.recorder("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.record();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to record a call with client
	// Client is set explicitly as shown below 
	// Pass call_id of the call
	private static void recordACallWithClient() {
		try {
			CallRecordCreateResponse response = Call.recorder("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
					.client(client)
					.record();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to stop call record
	// Client is set by Plivo.init helper method in main()
	// Pass call_id of the call
	private static void stopACallRecord() {
		try {
			Call.recordStopper("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.recordStop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to stop call record with client
	// Client is set explicitly as shown below 
	// Pass call_id of the call
	private static void stopACallRecordWithClient() {
		try {
			Call.recordStopper("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.client(client)
			.recordStop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to play audio on call
	// Client is set by Plivo.init helper method in main()
	// Pass call_id of the call and audio url of the call
	private static void playAudioOnACall() {
		try {
			CallPlayCreateResponse response = Call.player("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", Collections.singletonList("https://audio_url"))
					.play();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to play audio on call with client
	// Client is set explicitly as shown below 
	// Pass call_id of the call and audio url of the call

	private static void playAudioOnACallWithClient() {
		try {
			CallPlayCreateResponse response = Call.player("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", Collections.singletonList("https://audio_url"))
					.client(client)
					.play();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to stop audio on call 
	// Client is set by Plivo.init helper method in main()
	// Pass call_id of the  call

	private static void stopAudioOnACall() {
		try {
			Call.playStopper("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.playStop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to stop audio on call with client
	// Client is set explicitly as shown below 

	private static void stopAudioOnACallWithClient() {
		try {
			Call.playStopper("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.client(client)
			.playStop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to speak text on call
	// Client is set by Plivo.init helper method in main()
	//Pass call_id of the  call and text to speak


	private static void speakTextOnACall() {
		try {
			CallSpeakCreateResponse response = Call.speaker("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", "Hello World")
					.speak();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to speak text on call with client
	// Client is set explicitly as shown below 
	//Pass call_id of the  call and text to speak
	private static void speakTextOnACallWithClient() {
		try {
			CallSpeakCreateResponse response = Call.speaker("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", "Hello World")
					.client(client)
					.speak();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to stop text speak on call
	// Client is set by Plivo.init helper method in main()
	// Pass call_id of the  call

	private static void stopSpeakTextOnACall() {
		try {
			CallSpeakCreateResponse response = Call.speaker("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", "Hello World")
					.speak();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to stop text speak on call with client
	// Client is set explicitly as shown below 
	// Pass call_id of the  call

	private static void stopSpeakTextOnACallWithClient() {
		try {
			Call.speakStopper("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4")
			.client(client)
			.speakStop();

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example send digits on call
	// Client is set by Plivo.init helper method in main()
	// Pass call_id of the active call
	private static void sendDigitsOnACall() {
		try {
			CallDtmfCreateResponse response = Call.digitSender("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", "123")
					.sendDigits();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to send digits on call with client
	// Client is set explicitly as shown below 
	// Pass call_id of the active call

	private static void sendDigitsOnCallWithClient() {
		try {
			CallDtmfCreateResponse response = Call.digitSender("10f0cb68-XXX-XXXXX-acb5-87ceac29ee4", "123")
					.client(client)
					.sendDigits();

			System.out.println(response);

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}
}
