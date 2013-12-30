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

public class CDRTest {
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
			String recordId = "f69b5b1e-62d4-11e3-9da8-a3b81877b3b1";
			CDR cdr = CDR.get(recordId, restConf);

			assertNotNull(cdr);
			assertEquals("6281320903871", cdr.getToNumber());
			assertEquals(0, (int) cdr.getBillDuration());
			assertEquals(0, (int) cdr.getBilledDuration());
			assertEquals(0, (int) cdr.getCallDuration());
			assertEquals("0.00000", cdr.getTotalAmount());
			assertEquals(null, cdr.getParentCallUUID());
			assertEquals("inbound", cdr.getCallDirection());
			assertEquals("0.00300", cdr.getTotalRate());
			assertEquals("sip:iw4nbk131211053518@phone.plivo.com",
					cdr.getFromNumber());
			assertEquals("2013-12-12 02:27:37+00:00", cdr.getEndTime());
			assertEquals("f69b5b1e-62d4-11e3-9da8-a3b81877b3b1",
					cdr.getCallUUID());
			assertEquals(
					"/v1/Account/MAMJFLMZJKMZE0OTZHNT/Call/f69b5b1e-62d4-11e3-9da8-a3b81877b3b1/",
					cdr.getResourceUri());
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
			CDRList cdrList = CDR.getList(params, restConf);

			assertNotNull(cdrList);
			assertTrue(cdrList.getList().size() > 0);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}
}
