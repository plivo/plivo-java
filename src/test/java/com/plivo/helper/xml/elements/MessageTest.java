package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class MessageTest {
	@Test
	public void testMessage() {
		PlivoXML plivoXML = new PlivoXML();
		Message m = new Message("Hello, message from Plivo.", "1234", "5678");
		try {
			plivoXML.append(m);
			String expected = TestUtils.inStreamToString(MessageTest.class
					.getResourceAsStream("message_simple.xml"));
			assertEquals(expected, plivoXML.toXML());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
}
