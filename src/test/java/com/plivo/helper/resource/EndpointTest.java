package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;

public class EndpointTest {
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
			String endpointId = "85785376675499";
			Endpoint endpoint = Endpoint.get(endpointId, restConf);

			assertNotNull(endpoint);
			assertEquals("sip:iw4nbk131211052239@phone.plivo.com",
					endpoint.getSipUri());
			assertEquals("85785376675499", endpoint.getEndpointId());
			assertEquals("appsub", endpoint.getAlias());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
}
