package com.plivo.helper.resource;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestClient;
import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.factory.ApplicationFactory;

public class ApplicationTest {
	PlivoRestClient restClient;
	PlivoRestConf restConf;
	private String authId = "MAMJFLMZJKMZE0OTZHNT";
	private String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restClient = new PlivoRestClient(this.authId, this.authToken, "v1");
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}

	@Test
	public void testCreateModifyDeleteNew() {
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
			
			appId = Application.create(params, restConf);

			assertNotNull(appId);

			//edit			
			params = new LinkedHashMap<String, String>();
			params.put("app_id", appId);
			params.put("answer_method", "POST");
			params.put("hangup_url", "http://updated.com");
			params.put("hangup_method", "POST");
			params.put("fallback_answer_url", "http://updated.com");
			params.put("fallback_method",  "POST");
			params.put("message_url",  "http://updated.com");
			params.put("message_method", "POST");

			boolean modifyResult = Application.modify(appId, params, restConf);
			assertTrue(modifyResult);

			//verify our changes
			params = new LinkedHashMap<String, String>();
			params.put("app_id", appId);

			Application ap = Application.get(appId, restConf);

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
			boolean deleteResult = ap.delete();
			
			assertTrue(deleteResult);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}

	}

}
