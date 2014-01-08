package com.plivo.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class PlivoRestClientTest {
	PlivoRestClient restClient;
	private final String authId = "MAMJFLMZJKMZE0OTZHNT";
	private final String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restClient = new PlivoRestClient(this.authId, this.authToken, "v1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlivoRestClientVersion() {
		PlivoRestClient restClient = new PlivoRestClient(
				"MAXXXXXXXXXXXXXXXXXX",
				"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlivoRestClientInvalidAuthFormat() {
		PlivoRestClient restClient = new PlivoRestClient(
				"MAXXXXXXXXXXXXXXXXXX", "random_auth_token", "v1");
	}

	@Test
	public void testPlivoRestClientValid() {
		try {
			PlivoRestClient restClient = new PlivoRestClient(
					"MAXXXXXXXXXXXXXXXXXX",
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRequestNeedAuth() {
		PlivoRestClient restClient = new PlivoRestClient(
				"MAXXXXXXXXXXXXXXXXXX",
				"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");

		// auth required
		try {
			String response = restClient.request("GET", "/",
					new HashMap<String, String>());
			assertEquals(
					"Could not verify your access level for that URL.You have to login with proper credentials",
					response);
		} catch (PlivoException pe) {
			fail("PlivoException : " + pe.getMessage());
		}
	}

	@Test
	public void testRequestNotFound() {
		PlivoRestClient restClient = new PlivoRestClient(
				"MAXXXXXXXXXXXXXXXXXX",
				"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
		try {
			String response = restClient.request("GET", "/odongodong",
					new HashMap<String, String>());
			assertEquals("{ \"server_code\": 404,   \"error\": \"not found\"}",
					response);
		} catch (PlivoException pe) {
			fail("PlivoException : " + pe.getMessage());
		}
	}
}
