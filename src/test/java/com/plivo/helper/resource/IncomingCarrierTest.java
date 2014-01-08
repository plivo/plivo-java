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

public class IncomingCarrierTest {
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
			String carrierId = "51790098555742";
			IncomingCarrier ic = IncomingCarrier.get(carrierId, restConf);

			assertNotNull(ic);
			assertEquals(carrierId, ic.getCarrierId());
			assertEquals("Carrier Inc", ic.getName());
			assertEquals("127.0.0.1,192.168.1.1", ic.getIpSet());
			assertEquals(false, ic.getSms());
			assertEquals(true, ic.getVoice());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetList() {
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			IncomingCarrierList icl = IncomingCarrier.getList(params, restConf);

			assertNotNull(icl);
			assertTrue(icl.getList().size() >= 2);
			assertTrue(icl.getMeta().getTotalCount() >= 2);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testCreateEditDelete() {
		String carrierId = null;
		// create it
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("name", "unittest");
			params.put("ip_set", "192.168.0.1");

			carrierId = IncomingCarrier.create(params, restConf);
		} catch (PlivoException pe) {
			fail("Creating IncomingCarrier failed:" + pe.getMessage());
		} catch (APIException ae) {
			fail("Creating IncomingCarrier failed:" + ae.toString());
		}

		// modify
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("name", "unittest_modified");

			IncomingCarrier.modify(carrierId, params, restConf);
		} catch (PlivoException pe) {
			fail("Modifying IncomingCarrier failed:" + pe.getMessage());
		} catch (APIException ae) {
			fail("Modifying IncomingCarrier failed:" + ae.toString());
		}

		// verify it
		try {
			IncomingCarrier ic = IncomingCarrier.get(carrierId, restConf);

			assertNotNull(ic);
			assertEquals(carrierId, ic.getCarrierId());
			assertEquals("unittest_modified", ic.getName());
			assertEquals("192.168.0.1", ic.getIpSet());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
		// delete it
		try {
			IncomingCarrier.delete(carrierId, restConf);
		} catch (PlivoException pe) {
			fail("Deleting IncomingCarrier failed:" + pe.getMessage());
		} catch (APIException ae) {
			fail("Deleting IncomingCarrier id = " + carrierId + " failed:"
					+ ae.toString());
		}
	}
}
