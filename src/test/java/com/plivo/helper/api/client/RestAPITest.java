package com.plivo.helper.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.api.response.account.Account;
import com.plivo.helper.api.response.account.SubAccount;
import com.plivo.helper.api.response.account.SubAccountFactory;
import com.plivo.helper.api.response.application.Application;
import com.plivo.helper.api.response.application.ApplicationFactory;
import com.plivo.helper.api.response.endpoint.Endpoint;
import com.plivo.helper.api.response.endpoint.EndpointFactory;
import com.plivo.helper.api.response.number.NumberSearchFactory;
import com.plivo.helper.api.response.pricing.PlivoPricing;
import com.plivo.helper.exception.PlivoException;

public class RestAPITest {
	RestAPI restClient;
	@Before
	public void initTest() {
		restClient = new RestAPI("MAMJFLMZJKMZE0OTZHNT", "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3", "v1");
	}
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

	@Test
	public void testGetAccount() {
		try {
			Account account = restClient.getAccount();

			assertEquals("Iwan Budi Kusnanto", account.name);
			assertTrue(200 == account.serverCode);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	};

	@Test
	public void testGetSubAccounts() {
		try {
			SubAccountFactory saf = restClient.getSubaccounts();

			assertTrue(200 == saf.serverCode);
			assertEquals(1, saf.subAccountList.size());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetSubAccount() throws PlivoException {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("subauth_id", "SAODDKMDVLMJCWNDG5OT");

			SubAccount sa = restClient.getSubaccount(params);

			assertEquals("SAODDKMDVLMJCWNDG5OT", sa.authId);
			assertEquals(true, sa.isEnabled);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetApplications() {
		try {
			ApplicationFactory af = restClient.getApplications();

			assertTrue(200 == af.serverCode);
			assertEquals(5, af.applicationList.size());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetApplication() throws PlivoException {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("app_id", "13066057776063802");

			Application app = restClient.getApplication(params);

			assertTrue(200 == app.serverCode);
			assertEquals("Demo Speak", app.applicationName);
			assertEquals("13066057776063802", app.applicationID);
			assertEquals("https://s3.amazonaws.com/plivosamplexml/speak_url.xml", app.answerUrl);
			assertEquals("GET", app.answerMethod);
			assertEquals("GET", app.fallbackMethod);
			assertEquals("https://s3.amazonaws.com/plivosamplexml/fallback_url.xml", app.fallbackAnswerUrl);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetEndpoints() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			EndpointFactory ef = restClient.getEndpoints(params);

			assertTrue(200 == ef.serverCode);
			assertEquals(2, ef.endpointList.size());
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetEndpoint() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("endpoint_id", "85785376675499");

			Endpoint endpoint = restClient.getEndpoint(params);

			assertTrue(200 == endpoint.serverCode);
			assertEquals("sip:iw4nbk131211052239@phone.plivo.com", endpoint.sipUri);
			assertEquals("85785376675499", endpoint.endpointId);
			assertEquals("appsub", endpoint.alias);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetEndpointInvalidId() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("endpoint_id", "invalid_Id");

			Endpoint endpoint = restClient.getEndpoint(params);

			assertEquals("not found", endpoint.error);
			assertTrue(endpoint.serverCode == 404);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetNumbers() {
		try {
			NumberSearchFactory nsf = restClient.getNumbers();

			assertEquals(0, nsf.numberList.size());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
	@Test
	public void testPricing() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("country_iso", "US");

			PlivoPricing pricing = restClient.getPricing(params);

			assertEquals("United States", pricing.country);
			assertEquals("1", pricing.countryCode);
			assertEquals("US", pricing.countryIso);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testPricingInvalidCountry() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("country_iso", "XX");

			PlivoPricing pricing = restClient.getPricing(params);

			assertTrue(pricing.serverCode == 400);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}


	@Test
	public void testPricingEmptyParams() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			PlivoPricing pricing = restClient.getPricing(params);

			assertTrue(pricing.serverCode == 400);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

}
