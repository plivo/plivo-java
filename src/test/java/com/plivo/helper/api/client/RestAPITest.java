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
import com.plivo.helper.api.response.call.CDR;
import com.plivo.helper.api.response.call.CDRFactory;
import com.plivo.helper.api.response.call.LiveCallFactory;
import com.plivo.helper.api.response.endpoint.Endpoint;
import com.plivo.helper.api.response.endpoint.EndpointFactory;
import com.plivo.helper.api.response.message.Message;
import com.plivo.helper.api.response.message.MessageFactory;
import com.plivo.helper.api.response.number.NumberSearchFactory;
import com.plivo.helper.api.response.pricing.PlivoPricing;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;

public class RestAPITest {
	RestAPI restClient;
	private String authId = "MAMJFLMZJKMZE0OTZHNT";
	private String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restClient = new RestAPI(this.authId, this.authToken, "v1");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRestAPIVersion() {
		RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX",
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v10");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRestAPIInvalidAuthFormat() {
		RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX", "random_auth_token", "v1");
	}

	@Test
	public void testRestAPIValid() {
		try {
			RestAPI restAPI = new RestAPI("MAXXXXXXXXXXXXXXXXXX",
					"OTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "v1");
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail(e.getMessage());
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

	/**
	 * Test this helper to do multiple API calls
	 */
	@Test
	public void testMultipeCall() {
		try {
			restClient.getAccount();
			restClient.getAccount();
			restClient.getAccount();
			restClient.getAccount();
			restClient.getAccount();
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	};


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
			assertTrue(saf.subAccountList.size() >= 0);
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

			assertEquals(200, (int)sa.serverCode);
			assertEquals("SAODDKMDVLMJCWNDG5OT", sa.authId);
			assertEquals(true, sa.isEnabled);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testCreateEditDeleteSubAccount() {
		try {
			String subAuthId;
			GenericResponse gr;
			//create
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("name", "unittest");
			params.put("enabled", "false");

			SubAccount sa = restClient.makeSubaccount(params);

			assertEquals(201, (int)sa.serverCode);
			assertEquals(null, sa.error);

			subAuthId = sa.authId;

			//edit
			params = new LinkedHashMap<String, String>();

			params.put("subauth_id", subAuthId);
			params.put("name", "unittest_edited");
			params.put("enabled", "true");

			gr = restClient.editSubaccount(params);

			assertEquals(202, (int)gr.serverCode);
			assertEquals(null, gr.error);

			//verify our changes
			params = new LinkedHashMap<String, String>();

			params.put("subauth_id", subAuthId);

			sa = restClient.getSubaccount(params);

			assertEquals(200, (int)sa.serverCode);
			assertEquals(null, sa.error);
			assertEquals(true, sa.isEnabled);
			assertEquals("unittest_edited", sa.name);

			//delete
			params = new LinkedHashMap<String, String>();

			params.put("subauth_id", subAuthId);

			gr = restClient.deleteSubaccount(params);

			assertEquals(204, (int)gr.serverCode);
			assertEquals(null, gr.error);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
	@Test
	public void testGetApplications() {
		try {
			ApplicationFactory af = restClient.getApplications();

			assertTrue(200 == af.serverCode);
			assertTrue(af.applicationList.size() >= 5);
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

			assertEquals(200, (int)app.serverCode);
			assertEquals("Demo Speak", app.applicationName);
			assertEquals("13066057776063802", app.applicationID);
			assertEquals("https://s3.amazonaws.com/plivosamplexml/speak_url.xml", app.answerUrl);
			assertEquals("GET", app.answerMethod);
			assertEquals("GET", app.fallbackMethod);
			assertEquals("https://s3.amazonaws.com/plivosamplexml/fallback_url.xml", app.fallbackAnswerUrl);
			assertEquals(null, app.error);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetApplicationInvalidId() throws PlivoException {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("app_id", "XXXX6057776063802");

			Application app = restClient.getApplication(params);

			assertEquals(404, (int)app.serverCode);
			assertEquals("not found", app.error);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetMessages() {
		try {
			MessageFactory mf = restClient.getMessages();

			assertEquals(200, (int)mf.serverCode);
			assertEquals(null, mf.error);
			assertTrue(mf.messageList.size() > 0);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetMessage() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("record_id", "d56812f4-62e6-11e3-a9e2-1231400050ef");

			Message m = restClient.getMessage(params);

			assertEquals(200, (int)m.serverCode);
			assertEquals(null, m.error);
			assertEquals(null, m.cloudRate);
			assertEquals(null, m.carrierRate);
			assertEquals("outbound", m.messageDirection);
			assertEquals("6281320903871", m.toNumber);
			assertEquals("delivered", m.messageState);
			assertEquals("0.00880", m.totalAmount);
			assertEquals("6281320903872", m.fromNumber);
			assertEquals("d56812f4-62e6-11e3-a9e2-1231400050ef", m.messageUUID);
			assertEquals("2013-12-12 04:35:31+00:00", m.messageTime);
			assertEquals("/v1/Account/MAMJFLMZJKMZE0OTZHNT/Message/d56812f4-62e6-11e3-a9e2-1231400050ef/", m.resourceUri);
			assertEquals("sms", m.messageType);
			assertEquals(null, m.error);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}

	}
	@Test
	public void testGetMessageInvalidId() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("record_id", "XXXX12f4-62e6-11e3-a9e2-1231400050ef");

			Message m = restClient.getMessage(params);

			assertEquals(404, (int)m.serverCode);
			assertEquals("not found", m.error);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}

	}
	@Test
	public void testGetCDRs() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			CDRFactory cf = restClient.getCDRs(params);

			assertEquals(200, (int)cf.serverCode);
			assertEquals(null, cf.error);
			assertTrue(cf.cdrList.size() > 0);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetCDR() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("record_id", "f69b5b1e-62d4-11e3-9da8-a3b81877b3b1");
			CDR cdr = restClient.getCDR(params);

			assertEquals(200, (int)cdr.serverCode);
			assertEquals("6281320903871", cdr.toNumber);
			assertEquals(0, (int)cdr.billDuration);
			assertEquals(0, (int)cdr.billedDuration);
			assertEquals(0, (int)cdr.callDuration);
			assertEquals("0.00000", cdr.totalAmount);
			assertEquals(null, cdr.parentCallUUID);
			assertEquals("inbound", cdr.callDirection);
			assertEquals("0.00300", cdr.totalRate);
			assertEquals("sip:iw4nbk131211053518@phone.plivo.com", cdr.fromNumber);
			assertEquals("2013-12-12 02:27:37+00:00", cdr.endTime);
			assertEquals("f69b5b1e-62d4-11e3-9da8-a3b81877b3b1", cdr.callUUID);
			assertEquals("/v1/Account/MAMJFLMZJKMZE0OTZHNT/Call/f69b5b1e-62d4-11e3-9da8-a3b81877b3b1/", cdr.resourceUri);
			assertEquals(null, cdr.error);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	/**
	 * Testing getCDR with invalid record id.
	 */
	@Test
	public void testGetCDRInvalidRecordId() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("record_id", "abcdefgh-62d4-11e3-9da8-a3b81877b3b1");
			CDR cdr = restClient.getCDR(params);

			assertEquals(404, (int)cdr.serverCode);
			assertEquals("not found", cdr.error);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}


	@Test
	public void testGetLiveCalls() {
		try {
			LiveCallFactory lfc = restClient.getLiveCalls();

			assertEquals(200, (int)lfc.serverCode);
			assertEquals(null, lfc.error);
			assertTrue(lfc.liveCallList.size() == 0);
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testCreateEditDeleteEndpoint() {
		try {
			String endpointId;
			String username;

			//create test
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			params.put("username", "unittest");
			params.put("password", "weak_password");
			params.put("alias", "unittest");

			Endpoint newEndpoint = restClient.makeEndpoint(params);

			assertEquals(201, (int)newEndpoint.serverCode);
			assertEquals(null, newEndpoint.error);

			endpointId = newEndpoint.endpointId;
			username = newEndpoint.username;

			//edit test
			params = new LinkedHashMap<String, String>();

			params.put("endpoint_id", endpointId);
			params.put("alias", "new_alias");
			params.put("password", "new_password");
			params.put("app_id", "13067240731758303");

			GenericResponse gr = restClient.editEndpoint(params);

			assertEquals(202, (int)gr.serverCode);
			assertEquals(null, gr.error);

			//get endpoint to verify our changes
			params = new LinkedHashMap<String, String>();

			params.put("endpoint_id", endpointId);

			Endpoint e = restClient.getEndpoint(params);

			assertEquals(200, (int)e.serverCode);
			assertEquals(null, e.error);
			assertEquals("new_alias", e.alias);
			assertEquals(endpointId, e.endpointId);
			assertEquals(username, e.username);

			//delete
			params = new LinkedHashMap<String, String>();

			params.put("endpoint_id", endpointId);

			gr = restClient.deleteEndpoint(params);

			assertEquals(204, (int)gr.serverCode);
			assertEquals(null, gr.error);
		}catch (PlivoException pe) {
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
			assertEquals(404, (int)endpoint.serverCode);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testGetNumbers() {
		try {
			NumberSearchFactory nsf = restClient.getNumbers();

			assertEquals(200, (int)nsf.serverCode);
			assertEquals(0, nsf.numberList.size());
			assertEquals(null, nsf.error);
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

			assertEquals(400, (int)pricing.serverCode);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}


	@Test
	public void testPricingEmptyParams() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			PlivoPricing pricing = restClient.getPricing(params);

			assertEquals(400, (int)pricing.serverCode);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

}
