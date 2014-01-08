package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class ApplicationTest {
	PlivoRestConf restConf;
	private final String authId = "MAMJFLMZJKMZE0OTZHNT";
	private final String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}

	@Test
	public void testGet() {
		try {
			String appId = "13066057776063802";
			Application app = Application.get(appId, restConf);

			assertNotNull(app);
			assertEquals("Demo Speak", app.getApplicationName());
			assertEquals("13066057776063802", app.getApplicationID());
			assertEquals(
					"https://s3.amazonaws.com/plivosamplexml/speak_url.xml",
					app.getAnswerUrl());
			assertEquals("GET", app.getAnswerMethod());
			assertEquals("GET", app.getFallbackMethod());
			assertEquals(
					"https://s3.amazonaws.com/plivosamplexml/fallback_url.xml",
					app.getFallbackAnswerUrl());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testCreateModifyDelete() {
		String appId = null;
		String appName = null;
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			appName = UUID.randomUUID().toString();

			// create
			params.put("answer_url", "http://original.com");
			params.put("app_name", appName);
			params.put("answer_method", "GET");
			params.put("hangup_url", "http://original.com");
			params.put("hangup_method", "GET");
			params.put("fallback_answer_url", "http://original.com");
			params.put("fallback_method", "GET");
			params.put("message_url", "http://original.com");
			params.put("message_method", "GET");

			appId = Application.create(params, restConf);

			assertNotNull(appId);

		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}

		// edit it
		try {
			HashMap<String, String> params = new HashMap<String, String>();

			params.put("answer_method", "POST");
			params.put("hangup_url", "http://updated.com");
			params.put("hangup_method", "POST");
			params.put("fallback_answer_url", "http://updated.com");
			params.put("fallback_method", "POST");
			params.put("message_url", "http://updated.com");
			params.put("message_method", "POST");

			Application.modify(appId, params, restConf);

			// verify our changes
			Application ap = Application.get(appId, restConf);

			assertNotNull(ap);
			assertEquals(appName, ap.getApplicationName());
			assertEquals(appId, ap.getApplicationID());
			assertEquals("POST", ap.getAnswerMethod());
			assertEquals("http://updated.com", ap.getHangupUrl());
			assertEquals("POST", ap.getHangupMethod());
			assertEquals("http://updated.com", ap.getFallbackAnswerUrl());
			assertEquals("POST", ap.getFallbackMethod());
			assertEquals("http://updated.com", ap.getMessageUrl());
			assertEquals("POST", ap.getMessageMethod());
		} catch (PlivoException pe) {
			fail("Modify failed : " + pe.getMessage());
		} catch (APIException ae) {
			fail("Modify failed : " + ae.toString());
		}

		// delete it
		try {
			Application.delete(appId, restConf);
		} catch (PlivoException pe) {
			fail("Delete failed : " + pe.getMessage());
		} catch (APIException ae) {
			fail("Delete failed : " + ae.toString());
		}
	}

	@Test
	public void testGetList() {
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			ApplicationList al = Application.getList(params, restConf);

			assertNotNull(al);
			assertTrue(al.getList().size() >= 5);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetListWithLimit() {
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("limit", "3");

			ApplicationList al = Application.getList(params, restConf);

			assertNotNull(al);
			assertTrue(al.getMeta().getLimit() == 3);
			assertTrue(al.getList().size() <= 3);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}
}
