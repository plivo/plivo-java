package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class OutgoingCarrierTest {
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
			OutgoingCarrier oc = OutgoingCarrier
					.get("27110698855490", restConf);

			assertNotNull(oc);
			assertEquals("27110698855490", oc.getCarrierId());
			assertEquals("unittest", oc.getName());
			assertEquals(30, oc.getRetrySeconds());
			assertEquals(true, oc.getEnabled());
			assertEquals("174.36.238.136,184.173.113.136", oc.getIps());
			assertEquals("iwan.com", oc.getAddress());
			assertEquals(
					"/v1/Account/MAMJFLMZJKMZE0OTZHNT/OutgoingCarrier/27110698855490/",
					oc.getResourceUri());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetList() {
		try {
			OutgoingCarrierList ocl = OutgoingCarrier.getList(
					new HashMap<String, Object>(), restConf);

			assertNotNull(ocl);
			assertTrue(ocl.getMeta().getTotalCount() >= 1);
			assertTrue(ocl.getList().size() >= 1);
		} catch (PlivoException pe) {
			fail("Plivo Exception : " + pe.getMessage());
		} catch (APIException ae) {
			fail("API Exception : " + ae.toString());
		}
	}

	@Test
	public void testCreateModifyDelete() {
		String carrierId = null;

		// create
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("name", "unittest_java");
			params.put("address", "google.com");
			carrierId = OutgoingCarrier.create(params, restConf);

			assertNotNull(carrierId);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}

		// modify
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("name", "unittest_java_edited");
			params.put("address", "google.com");
			OutgoingCarrier.modify(carrierId, params, restConf);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}

		// verify our changes
		try {
			OutgoingCarrier oc = OutgoingCarrier.get(carrierId, restConf);
			assertNotNull(oc);
			assertEquals("unittest_java_edited", oc.getName());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}

		// delete
		try {
			OutgoingCarrier.delete(carrierId, restConf);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}
}
