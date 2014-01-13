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

public class RecordingTest {
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
			String recId = "160b3532-7c1b-11e3-9e7b-0026b92f9684";
			Recording r = Recording.get(recId, restConf);

			assertNotNull(r);
			assertEquals(
					"http://s3.amazonaws.com/recordings_2013/160b3532-7c1b-11e3-9e7b-0026b92f9684.mp3",
					r.getRecordingURL());
			assertEquals("1389594152753.00000", r.getRecordingStartMs());
			assertEquals("1389594170693.00000", r.getRecordingEndMs());
			assertEquals("17940.00000", r.getRecordingDurationMs());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

	@Test
	public void testGetList() {
		try {
			RecordingList rl = Recording.getList(new HashMap<String, Object>(),
					restConf);

			assertNotNull(rl);
			assertTrue(rl.getList().size() >= 2);
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}
}
