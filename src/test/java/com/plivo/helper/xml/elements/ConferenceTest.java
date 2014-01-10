package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class ConferenceTest {
	@Test
	public void testSimpleConf() {
		PlivoXML plivoXML = new PlivoXML();
		Conference conf = new Conference("Simple Conference");

		try {
			plivoXML.append(conf);

			String expected = TestUtils.inStreamToString(SpeakTest.class.getResourceAsStream("conference_simple.xml"));

			assertEquals(expected, plivoXML.toXML());
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

	@Test
	public void testModeratedConf() {
		PlivoXML response = new PlivoXML();
		Conference conf = new Conference("Moderated Conference");

		conf.setStartConferenceOnEnter(false);
		conf.setWaitSound("http://www.foo.com/waitmusic/");

		try {
			response.append(conf);

			String expected = TestUtils.inStreamToString(SpeakTest.class.getResourceAsStream("conference_moderated.xml"));

			assertEquals(expected, response.toXML());
		}catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}

}
