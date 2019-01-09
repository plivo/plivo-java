package com.plivo.examples;

import java.io.IOException;

import com.plivo.api.Client;
import com.plivo.api.PhloClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.MultiPartyCallUpdateResponse;
import com.plivo.api.models.node.MultiPartyCallUpdater;

public class MulitpartyCallAPI {
	private static final String authId = "XXXXXXXXXXXXXXXXMZ";
	private static final String authToken = "NzUyYTXXXXXXXXXXXXXX5YTJmNTgwMDI4";
	private static final String phloID = "2e802f94-XXXXXX_XXXXX_XX5a0328544135";
	private static final String nodeID = "b18848dd-XXXXX-XXXXXX-XXXXXc274d5fb7";
	private static final String triggerSource = "111111111";
	private static final String to = "00000000000";
	private static final String role = "agent";
	private static final String memberID = "00000000000";
	private static Client phloClient = new PhloClient(authId, authToken).getClient();
	
	public static void main(String[] args) {
		testMultiPartyCallGetter();
	}


	private static void testMultiPartyCallGetter() {

	
		MultiPartyCall resp = null;
		try {
			resp = MultiPartyCall.getter(phloID, nodeID).client(phloClient).get();
			System.out.println(resp);	  
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private static void testMultipartyCallCall() {
		MultiPartyCallUpdateResponse response = null;
		try {
			MultiPartyCall.getter(phloID, nodeID).client(phloClient).get();
			response = MultiPartyCall.updater(phloID, nodeID).client(phloClient).
					triggerSource(triggerSource).to(to).role(role).call().update();
			System.out.println(response);
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static void testMultipartyCalllWarmTransfer() {
		MultiPartyCallUpdateResponse response = null;
		try {
			MultiPartyCall.getter(phloID, nodeID).client(phloClient).get();
			response = MultiPartyCall.updater(phloID, nodeID).client(phloClient).
					triggerSource(triggerSource).to(to).role(role).warm_transfer().update();
			System.out.println(response);
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private static void testMultipartyCalllColdTransfer() {
		MultiPartyCallUpdateResponse response = null;
		try {
			MultiPartyCall.getter(phloID, nodeID).client(phloClient).get();
			response = MultiPartyCall.updater(phloID, nodeID).client(phloClient).
					triggerSource(triggerSource).to(to).role(role).cold_transfer().update();
			System.out.println(response);	
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void testMultipartyCalllHold() throws IOException {
		MultiPartyCallUpdater resp = null;
		try {
			MultiPartyCall.getter(phloID, nodeID).client(phloClient).get();
			resp = MultiPartyCall.updater(phloID, nodeID).client(phloClient).
					triggerSource(triggerSource).to(to).role(role).member(memberID).hold();	
			System.out.println(resp);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
