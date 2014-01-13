package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.response.EndpointCreateResponse;

public class EndpointTest {
	PlivoRestConf restConf;
	private final String authId = "MAMJFLMZJKMZE0OTZHNT";
	private final String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}

	/**
	 * Test get details of an endpoint
	 */
	@Test
	public void testGet() {
		try {
			String endpointId = "85785376675499";
			Endpoint endpoint = Endpoint.get(endpointId, restConf);

			assertEquals("sip:iw4nbk131211052239@phone.plivo.com",
					endpoint.getSipUri());
			assertEquals(endpointId, endpoint.getEndpointId());
			assertEquals("appsub", endpoint.getAlias());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.getServerCode() + ":" + ae.getMessage());
		}
	}

	/**
	 * test get endpoint list
	 */
	@Test
	public void testGetList() {
		try {
			EndpointList el = Endpoint.getList(restConf);

			assertNotNull(el);
			assertTrue(el.getList().size() > 2);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	/**
	 * Create-edit-delete test
	 */
	@Test
	public void testCreateEditDelete() {
		try {
			String endpointId;
			String username;
			// Create
			Map<String, String> params = new HashMap<String, String>();

			params.put("username", "unittest");
			params.put("password", "weak_password");
			params.put("alias", "unittest");

			EndpointCreateResponse er = Endpoint.create(params, restConf);

			assertNotNull(er);
			assertNotNull(er.getEndpointId());

			endpointId = er.getEndpointId();
			username = er.getUsername();
			// Edit it
			params = new HashMap<String, String>();

			params.put("alias", "new_alias");
			params.put("password", "new_password");
			params.put("app_id", "13067240731758303");

			Endpoint.modify(er.getEndpointId(), params, restConf);

			// verify our changes
			Endpoint ep = Endpoint.get(endpointId, restConf);

			assertNotNull(ep);
			assertEquals("new_alias", ep.getAlias());
			assertEquals(endpointId, ep.getEndpointId());
			assertEquals(username, ep.getUsername());

			// Delete it
			Endpoint.delete(er.getEndpointId(), restConf);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}
}
