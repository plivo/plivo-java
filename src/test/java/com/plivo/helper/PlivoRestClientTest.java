package com.plivo.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.resource.Account;
import com.plivo.helper.resource.Application;


public class PlivoRestClientTest {
	PlivoRestClient restClient;
	private String authId = "MAMJFLMZJKMZE0OTZHNT";
	private String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restClient = new PlivoRestClient(this.authId, this.authToken, "v1");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPlivoRestClientVersion() {
		PlivoRestClient restClient = new PlivoRestClient("MAXXXXXXXXXXXXXXXXXX",
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v10");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPlivoRestClientInvalidAuthFormat() {
		PlivoRestClient restClient = new PlivoRestClient("MAXXXXXXXXXXXXXXXXXX", "random_auth_token", "v1");
	}

	@Test
	public void testPlivoRestClientValid() {
		try {
			PlivoRestClient restClient = new PlivoRestClient("MAXXXXXXXXXXXXXXXXXX",
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRequestNeedAuth() {
		PlivoRestClient restClient = new PlivoRestClient("MAXXXXXXXXXXXXXXXXXX", "OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");

		//auth required
		try {
			String response = restClient.request("GET", "/", new LinkedHashMap<String, String>());
			assertEquals("Could not verify your access level for that URL.You have to login with proper credentials", response);
		} catch (PlivoException pe) {
			fail("PlivoException : " + pe.getMessage());
		}
	}

	@Test
	public void testRequestNotFound() {
		PlivoRestClient restClient = new PlivoRestClient("MAXXXXXXXXXXXXXXXXXX", "OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
		try {
			String response = restClient.request("GET", "/odongodong", new LinkedHashMap<String, String>());
			assertEquals("{ \"server_code\": 404,   \"error\": \"not found\"}", response);
		} catch (PlivoException pe) {
			fail("PlivoException : " + pe.getMessage());
		}
	}
	
	@Test
	public void testGetAccount() {
		try {
			Account account = restClient.getAccount();
			
			assertTrue(account.isOK() == true);
			assertEquals("Iwan Budi Kusnanto", account.getName());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	};

	@Test
	public void testGetApplication() throws PlivoException {
		try {
			Application app = restClient.getAccount().getApplication("13066057776063802");

			assertTrue(app.isOK());
			assertEquals("Demo Speak", app.getApplicationName());
			assertEquals("13066057776063802", app.getApplicationID());
			assertEquals("https://s3.amazonaws.com/plivosamplexml/speak_url.xml", app.getAnswerUrl());
			assertEquals("GET", app.getAnswerMethod());
			assertEquals("GET", app.getFallbackMethod());
			assertEquals("https://s3.amazonaws.com/plivosamplexml/fallback_url.xml", app.getFallbackAnswerUrl());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

}