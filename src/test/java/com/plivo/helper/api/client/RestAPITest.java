package com.plivo.helper.api.client;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Test;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.exception.PlivoException;

public class RestAPITest {

	@Test
	public void testRestAPIVersion() {
		try {
			RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX", 
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v10");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testRestAPIInvalidAuthFormat() {
		try {
			RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX", "random_auth_token", "v1");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testRestAPIValid() {
		try {
			RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX",
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testRequestNeedAuth() {
		RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX", "OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
		
		//auth required
		try {
			String response = restAPI.request("GET", "/", new LinkedHashMap<String, String>());
			assertEquals("Could not verify your access level for that URL.You have to login with proper credentials", response);
		} catch (PlivoException pe) {
			fail("PlivoException : " + pe.getMessage());
		}
	}
	
	@Test
	public void testRequestNotFound() {
		RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX", "OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
		try {
			String response = restAPI.request("GET", "/odongodong", new LinkedHashMap<String, String>());
			assertEquals("{ \"server_code\": 404,   \"error\": \"not found\"}", response);
		} catch (PlivoException pe) {
			fail("PlivoException : " + pe.getMessage());
		}
	}
}
