package com.plivo.helper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.plivo.helper.PlivoRestConf;
import com.plivo.helper.exception.APIException;
import com.plivo.helper.exception.PlivoException;

public class PricingTest {
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
			Pricing pricing = Pricing.get("US", restConf);

			assertNotNull(pricing);
			assertNotNull(pricing.getPhoneNumbers());
			assertNotNull(pricing.getSmsRates());
			assertNotNull(pricing.getVoiceRates());
			assertEquals("United States", pricing.getCountry());
			assertEquals("1", pricing.getCountryCode());
			assertEquals("US", pricing.getCountryIso());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		} catch (APIException ae) {
			fail(ae.toString());
		}
	}

}
