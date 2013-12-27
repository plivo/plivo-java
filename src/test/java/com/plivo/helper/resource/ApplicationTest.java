package com.plivo.helper.resource;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.factory.ApplicationFactory;

public class ApplicationTest {
	PlivoRestClient restClient;
	private String authId = "MAMJFLMZJKMZE0OTZHNT";
	private String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restClient = new PlivoRestClient(this.authId, this.authToken, "v1");
	}
	
	@Test
	public void testCreateModifyDelete() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			String appName = UUID.randomUUID().toString();
			String appId;
			
			//create
			params.put("answer_url", "http://original.com");
			params.put("app_name", appName);
			params.put("answer_method", "GET");
			params.put("hangup_url", "http://original.com");
			params.put("hangup_method", "GET");
			params.put("fallback_answer_url", "http://original.com");
			params.put("fallback_method",  "GET");
			params.put("message_url",  "http://original.com");
			params.put("message_method", "GET");
			
			ApplicationFactory af = restClient.getAccount().getApplicationFactory();
			appId = af.create(params);

			assertNotNull(appId);

			//edit
			Application app = new Application(restClient, appId);
			
			params = new LinkedHashMap<String, String>();
			params.put("app_id", appId);
			params.put("answer_method", "POST");
			params.put("hangup_url", "http://updated.com");
			params.put("hangup_method", "POST");
			params.put("fallback_answer_url", "http://updated.com");
			params.put("fallback_method",  "POST");
			params.put("message_url",  "http://updated.com");
			params.put("message_method", "POST");

			boolean modifyResult = app.modify(params);
			assertTrue(modifyResult);

			//verify our changes
			params = new LinkedHashMap<String, String>();
			params.put("app_id", appId);

			Application ap = restClient.getAccount().getApplication(appId);

			assertTrue(ap.isOK());
			assertEquals(appName, ap.getApplicationName());
			assertEquals(appId, ap.getApplicationID());
			assertEquals("POST", ap.getAnswerMethod());
			assertEquals("http://updated.com", ap.getHangupUrl());
			assertEquals("POST", ap.getHangupMethod());
			assertEquals("http://updated.com", ap.getFallbackAnswerUrl());
			assertEquals("POST", ap.getFallbackMethod());
			assertEquals("http://updated.com", ap.getMessageUrl());
			assertEquals("POST", ap.getMessageMethod());

			//delete
			boolean deleteResult = app.delete();
			
			assertTrue(deleteResult);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}

	}

}
