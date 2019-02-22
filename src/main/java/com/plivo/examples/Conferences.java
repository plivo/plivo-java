package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.conference.Conference;
import com.plivo.api.models.conference.ConferenceList;
import com.plivo.api.models.conference.ConferenceMemberActionResponse;
import com.plivo.api.models.conference.ConferenceRecordCreateResponse;

public class Conferences {
	//Initialize the following authId and authToken with valid authId and authToken

	private static final String authId = "MANTXXXXXXXXXXXXXXXX";
	private static final String authToken = "ZMANTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static PlivoClient client = new PlivoClient(authId, authToken);

	public static void main(String[] args) {
		Plivo.init(authId, authToken);
		getConferenceDetails();
	}

	// Example to get details of a Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name
	private static void getConferenceDetails() {
		try {
			Conference response = Conference.getter("My Conf Room")
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to get details of a Conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name 

	private static void getConferenceDetailsWithClient() {
		try {
			Conference response = Conference.getter("My Conf Room")
					.client(client)
					.get();
			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to record a Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name
	private static void recordConference() {

		try {
			ConferenceRecordCreateResponse response = Conference.recorder("My Conf Room")
					.record();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to record a Conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name 
	private static void recordConferenceWithClient() {

		try {
			ConferenceRecordCreateResponse response = Conference.recorder("My Conf Room")
					.client(client)
					.record();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to stop  a Conference record
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name
	private static void stopConferenceRecord() {

		try {
			Conference.recordStopper("My Conf Room")
			.stop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to stop  a Conference record with client
	// Client is set explicitly as shown below 
	// Pass the conference name 
	private static void stopConferenceRecordWithClient() {

		try {
			Conference.recordStopper("My Conf Room")
			.client(client)
			.stop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete  a Conference 
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name
	private static void deleteConference() {

		try {
			Conference.deleter("My Conf Room")
			.delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete  a Conference  with client
	// Client is set explicitly as shown below 
	// Pass the conference name 
	private static void deleteConferenceWithClient() {

		try {
			Conference.deleter("My Conf Room")
			.client(client)
			.delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to delete  all Conference 
	// Client is set by Plivo.init helper method in main()

	private static void deleteAllConferences() {

		try {
			Conference.allDeleter()
			.delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to delete  all Conference  with client
	// Client is set explicitly as shown below 

	private static void deleteAllConferencesWithClient() {

		try {
			Conference.allDeleter()
			.client(client)
			.delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all Conferences
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name
	private static void listConferences() {

		try {
			ConferenceList response = Conference.listGetter()
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to list all Conferences with client
	// Client is set explicitly as shown below 
	// Pass the conference name 
	private static void listConferencesWithClient() {

		try {
			ConferenceList response = Conference.listGetter()
					.client(client)
					.get();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to hang up a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name and member ID
	private static void hangupAMemberInConferences() {

		try {
			Conference.memberHangupper("My Conf Room", "1")
			.hangup();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to hang up a member in a  Conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void hangupAMemberInConferencesWithClient() {

		try {
			Conference.memberHangupper("My Conf Room", "1")
			.client(client)
			.hangup();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to kickout a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name and member ID
	private static void kickAMemberInConferences() {

		try {
			Conference.memberKicker("My Conf Room", "1")
			.kick();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to kick a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void kickAMemberInConferencesWithClient() {

		try {
			Conference.memberKicker("My Conf Room", "1")
			.client(client)
			.kick();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}


	// Example to mute a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name and member ID
	private static void muteAMemberInConferences() {

		try {
			Conference.memberMuter("My Conf Room", "1")
			.mute();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to mute a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void muteAMemberInConferencesWithClient() {

		try {
			Conference.memberMuter("My Conf Room", "1")
			.client(client)
			.mute();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}



	// Example to unmute a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name and member ID
	private static void unmuteAMemberInConferences() {

		try {
			Conference.memberMuteStopper("My Conf Room", "1")
			.stop();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to unmute a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void unmuteAMemberInConferencesWithClient() {

		try {
			Conference.memberMuteStopper("My Conf Room", "1")
			.client(client)
			.stop();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}

	// Example to deaf a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name and member ID
	private static void deafAMemberInConferences() {

		try {
			Conference.memberDeafer("My Conf Room", "1")
			.deaf();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to deaf a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void deafAMemberInConferencesWithClient() {

		try {
			Conference.memberDeafer("My Conf Room", "1")
			.client(client)
			.deaf();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}


	// Example to undeaf a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name and member ID
	private static void undeafAMemberInConferences() {

		try {
			Conference.memberDeafStopper("My Conf Room", "1")
			.stop();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to undeaf a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void undeafAMemberInConferencesWithClient() {

		try {
			Conference.memberDeafStopper("My Conf Room", "1")
			.client(client)
			.stop();

			System.out.println("Deleted successfully.");
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}


	// Example to play audio to a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name ,  member ID and audio url
	private static void playAudioToAMemberInConferences() {

		try {
			ConferenceMemberActionResponse response = Conference.memberPlayer("My Conf Room", "10", "https://audio_url")
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to play audio to a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID and audio url
	private static void playAudioToMemberInConferencesWithClient() {

		try {
			ConferenceMemberActionResponse response = Conference.memberPlayer("My Conf Room", "10", "https://audio_url")
					.client(client)
					.create();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}


	// Example to stop audio to a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name ,  member ID 
	private static void stopAudioToAMemberInConferences() {

		try {
			Conference.memberPlayStopper("My Conf Room", "10")
			.stop();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to stop audio to a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void stopAudioToMemberInConferencesWithClient() {

		try {
			Conference.memberPlayStopper("My Conf Room", "10")
			.stop();

		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}

	// Example to play Text to a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name ,  member ID and text to play
	private static void playTextToAMemberInConferences() {

		try {
			ConferenceMemberActionResponse response = Conference.memberSpeaker("My Conf Room", "10", "Hello World!")
					.speak();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to play Text to a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID and text to play
	private static void playTextToMemberInConferencesWithClient() {
		try {
			ConferenceMemberActionResponse response = Conference.memberSpeaker("My Conf Room", "10", "Hello World!")
					.client(client)
					.speak();

			System.out.println(response);
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}


	// Example to stop play text to a member in a  Conference
	// Client is set by Plivo.init helper method in main()
	// Pass the conference name ,  member ID 
	private static void stopPlayTextToAMemberInConferences() {

		try {
			Conference.memberSpeakStopper("My Conf Room", "10")
			.delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}
	}

	// Example to stop play text to a member in a conference with client
	// Client is set explicitly as shown below 
	// Pass the conference name  and member ID 
	private static void stopPlayTextToMemberInConferencesWithClient() {

		try {
			Conference.memberSpeakStopper("My Conf Room", "10")
			.client(client)
			.delete();
		} catch (PlivoRestException | IOException e) {
			e.printStackTrace();
		}

	}

}
