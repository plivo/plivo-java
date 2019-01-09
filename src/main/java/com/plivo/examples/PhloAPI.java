package com.plivo.examples;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.plivo.api.Client;
import com.plivo.api.PhloClient;
import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.phlo.Phlo;
import com.plivo.api.models.phlo.PhloUpdateResponse;

public class PhloAPI {
	private static final String authId = "XXXXXXXXXXXXXXXXMZ";
	private static final String authToken = "NzUyYTXXXXXXXXXXXXXX5YTJmNTgwMDI4";
	private static final String phloID = "2e802f94-XXXXXX_XXXXX_XX5a0328544135";

	private static Client phloClient = new PhloClient(authId, authToken).getClient();

	public static void main(String[] args) {
		phloGetterWithInit();
	}


	private static void phloGetterWithInit() {
		Plivo.init(authId, authToken);
		Phlo resp = null;
		try {
			resp = Phlo.getter(phloID).get();
			System.out.println(resp);
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private static void phloGetterWithClient() {
		Phlo resp = null;
		try {
			resp = Phlo.getter(phloID).client(phloClient).get();
			System.out.println(resp);
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testPhloWithPayload() {
		PhloUpdateResponse resp = null;
		try {
			Map<String, Object> payload = new HashMap<>();
			payload.put("from", "XXXXXXXXXX");
			payload.put("to", "XXXXXXXXX");

			resp = Phlo.updater(phloID).client(phloClient).payload(payload).run();
			System.out.println(resp);	 
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void testPhloWithoutPayload() {
		PhloUpdateResponse resp = null;
		try {
			resp = Phlo.updater(phloID).client(phloClient).run();
			System.out.println(resp);	  
		} catch (IOException | PlivoRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
