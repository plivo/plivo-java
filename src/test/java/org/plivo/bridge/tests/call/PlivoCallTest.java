package org.plivo.bridge.tests.call;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.util.HashMap;
import java.util.Map;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.tests.call.servlets.AnsweredServlet;
import org.plivo.bridge.tests.call.servlets.HangupServlet;
import org.plivo.bridge.tests.call.servlets.RingingServlet;
import org.plivo.bridge.tests.call.servlets.TransferedServlet;
import org.plivo.bridge.to.request.BulkCallRequest;
import org.plivo.bridge.to.request.CallRequest;
import org.plivo.bridge.to.request.CancelScheduleHangupRequest;
import org.plivo.bridge.to.request.HangupAllCallRequest;
import org.plivo.bridge.to.request.HangupCallRequest;
import org.plivo.bridge.to.request.ScheduleHangupRequest;
import org.plivo.bridge.to.request.TransfCallRequest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlivoCallTest {
	PlivoClient client;

	private SimpleServer server;

	public PlivoCallTest() {
		client = PlivoClient.create("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
				"YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY",
				"http://205.185.125.36:8088", false);
	}

	@BeforeClass
	public void setUp( ) throws Exception {
		
		server = new SimpleServer(5151, new SimpleServer.ServletContainer(AnsweredServlet.class, "answered"),
				new SimpleServer.ServletContainer(RingingServlet.class, "ringing"),
				new SimpleServer.ServletContainer(HangupServlet.class, "hangup"),
				new SimpleServer.ServletContainer(TransferedServlet.class, "transfered"));
		server.start();
		
	}
	
	@AfterClass
	public void tearDown( ) throws Exception {
		System.out.println("Shutting down server ...");
		server.stop();
	}

	@Test(enabled=true)
	public void makeCall() throws Exception {
		/*
		    'From': '919191919191', # Caller Id
		    'To' : '1000', # User Number to Call
		    'Gateways' : "user/", # Gateway string to try dialing our separated by comma. First in list will be tried first
		    'GatewayCodecs' : "'PCMA,PCMU'", # Codec string as needed by FS for each gateway separated by comma
		    'GatewayTimeouts' : "60",      # Seconds to timeout in string for each gateway separated by comma
		    'GatewayRetries' : "1", # Retry String for Gateways separated by comma, on how many times each gateway should be retried
		    'OriginateDialString' : originate_dial_string,
		    'AnswerUrl' : "http://127.0.0.1:5000/answered/",
		    'HangUpUrl' : "http://127.0.0.1:5000/hangup/",
		    'RingUrl' : "http://127.0.0.1:5000/ringing/"
		 */


		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("From", "1001");
		parameters.put("To", "1002");

		parameters.put("Gateways", "user/");
		parameters.put("GatewayCodecs", "PCMA,PCMU");
		parameters.put("GatewayTimeouts", "60");
		parameters.put("GatewayRetries", "1");
		parameters.put("OriginateDialString", "originate_dial_string");
		parameters.put("AnswerUrl", "http://189.15.113.23:5151/answered");
		parameters.put("HangUpUrl", "http://189.15.113.23:5151/hangup");
		parameters.put("RingUrl", "http://189.15.113.23:5151/ringing");

		CallRequest result = client.call().single(parameters);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isSuccess());
		Thread.sleep(10000);
	}

	@Test(enabled=true)
	public void makeBulkCall() throws Exception {
		/*
		    'Delimiter' : '>', # Delimter for the bulk list
		    'From': '919191919191', # Caller Id
		    'To' : '1000>1000', # User Numbers to Call separated by delimeter
		    'Gateways' : "user/>user/", # Gateway string for each number separated by delimeter
		    'GatewayCodecs' : "'PCMA,PCMU'>'PCMA,PCMU'", # Codec string as needed by FS for each gateway separated by delimeter
		    'GatewayTimeouts' : "60>30", # Seconds to timeout in string for each gateway separated by delimeter
		    'GatewayRetries' : "2>1", # Retry String for Gateways separated by delimeter, on how many times each gateway should be retried
		    'OriginateDialString' : originate_dial_string,
		    'AnswerUrl' : "http://127.0.0.1:5000/answered/",
		    'HangUpUrl' : "http://127.0.0.1:5000/hangup/",
		    'RingUrl' : "http://127.0.0.1:5000/ringing/"
		 */

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("From", "1001");
		parameters.put("To", "1002>1003");

		parameters.put("Delimiter", ">");
		parameters.put("Gateways", "user/>user/");
		parameters.put("GatewayCodecs", "PCMA,PCMU'>'PCMA,PCMU");
		parameters.put("GatewayTimeouts", "60>30");
		parameters.put("GatewayRetries", "2>1");
		parameters.put("OriginateDialString", "bridge_early_media=true,hangup_after_bridge=true");
		parameters.put("AnswerUrl", "http://189.15.113.23:5151/answered/");
		parameters.put("HangUpUrl", "http://189.15.113.23:5151/hangup/");
		parameters.put("RingUrl", "http://189.15.113.23:5151/ringing/");

		BulkCallRequest result = client.call().bulk(parameters);

		System.out.println(result);
	}

	@Test(enabled=true)
	public void transf() throws Exception {
		/*
	    'URL' : "http://127.0.0.1:5000/transfered/",
	    'CallUUID' : 'edaa59e1-79e0-41de-b016-f7a7570f6e9c', # Request UUID to hangup call
		 */
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("URL", "http://189.15.113.23:5151/transfered/");
		parameters.put("CallUUID", "edaa59e1-79e0-41de-b016-f7a7570f6e9c");

		TransfCallRequest result = client.call().transfer(parameters);

		System.out.println(result);
	}

	@Test(enabled=true)
	public void hangUp() throws Exception {
		/*
 			'CallUUID' : 'edaa59e1-79e0-41de-b016-f7a7570f6e9c', # Request UUID to hangup call
		 */

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("CallUUID", "edaa59e1-79e0-41de-b016-f7a7570f6e9c");
		HangupCallRequest result = client.call().hangUp(parameters);

		System.out.println(result);
	}

	@Test(enabled=true)
	public void hangUpAll() throws Exception {
		/*
		 * 
		 */
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("Delimiter", ",");
		parameters.put("CallUUID", "edaa59e1-79e0-41de-b016-f7a7570f6e9c,edaa59e1-79e0-41de-b016-f7a7570f6e9c,edaa59e1-79e0-41de-b016-f7a7570f6e9c");
		HangupAllCallRequest result = client.call().hangUpAll(parameters);

		System.out.println(result);
	}

	@Test(enabled=true)
	public void scheduleHangUp() throws Exception {
		/*
		 * 
		 */
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("CallUUID", "edaa59e1-79e0-41de-b016-f7a7570f6e9c");
		parameters.put("Time", "10000");
		ScheduleHangupRequest result = client.call().scheduleHangup(parameters);

		System.out.println(result);
	}

	@Test(enabled=true)
	public void cancelScheduleHangUp() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("SchedHangupId", "1");
		CancelScheduleHangupRequest result;
		
		try {
			result = client.call().cancelScheduledHangup(parameters);
			System.out.println(result);
		} catch (PlivoClientException e) {
			System.out.println(e.getHttpMessage());
			System.out.println(e.getHttpStatusCode());
		}
	}
}
