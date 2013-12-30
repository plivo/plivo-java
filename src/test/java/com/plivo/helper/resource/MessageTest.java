package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class MessageTest {
	PlivoRestConf restConf;
	private final String authId = "MAMJFLMZJKMZE0OTZHNT";
	private final String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}

	@Test
	public void testGetMessage() {
		try {
			String recordId = "d56812f4-62e6-11e3-a9e2-1231400050ef";

			Message m = Message.get(recordId, restConf);

			assertNotNull(m);
			assertEquals(null, m.getCloudRate());
			assertEquals(null, m.getCarrierRate());
			assertEquals("outbound", m.getMessageDirection());
			assertEquals("6281320903871", m.getToNumber());
			assertEquals("delivered", m.getMessageState());
			assertEquals("0.00880", m.getTotalAmount());
			assertEquals("6281320903872", m.getFromNumber());
			assertEquals("d56812f4-62e6-11e3-a9e2-1231400050ef",
					m.getMessageUUID());
			assertEquals("2013-12-12 04:35:31+00:00", m.getMessageTime());
			assertEquals(
					"/v1/Account/MAMJFLMZJKMZE0OTZHNT/Message/d56812f4-62e6-11e3-a9e2-1231400050ef/",
					m.getResourceUri());
			assertEquals("sms", m.getMessageType());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetList() {
		try {
			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

			MessageList ml = Message.getList(params, restConf);

			assertNotNull(ml);
			assertTrue(ml.getList().size() > 0);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}

	}
}
