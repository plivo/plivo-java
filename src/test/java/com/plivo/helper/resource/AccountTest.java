package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.PlivoException;

public class AccountTest {
	PlivoRestConf restConf;
	private String authId = "MAMJFLMZJKMZE0OTZHNT";
	private String authToken = "YmE1N2NiMDhiNTZlMWE1YjU3NzAwYmYyYTVmYjg3";

	@Before
	public void initTest() {
		restConf = new PlivoRestConf(this.authId, this.authToken, "v1");
	}
	
	@Test
	public void testGet() {
		try {
			Account a = Account.get(restConf);

			assertNotNull(a);
			assertEquals("MAMJFLMZJKMZE0OTZHNT", a.getAuthID());
			assertEquals("Iwan Budi Kusnanto", a.getName());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
}
