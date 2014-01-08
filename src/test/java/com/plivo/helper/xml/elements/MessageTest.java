package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class MessageTest {
	@Test
	public void testMessage() {
		PlivoResponse response = new PlivoResponse();
		Message m = new Message("Hello, message from Plivo.", "1234", "5678");
		try {
			response.append(m);
			String expected = TestUtils.inStreamToString(MessageTest.class
					.getResourceAsStream("message_simple.xml"));
			assertEquals(expected, response.toXML());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
}
