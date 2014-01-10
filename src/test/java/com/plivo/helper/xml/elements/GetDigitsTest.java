package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class GetDigitsTest {
	@Test
	public void testGetDigits() {
		PlivoXML plivoXML = new PlivoXML();
		Speak speak = new Speak("Press one for English. Press two for Spanish");
		GetDigits getdigits = new GetDigits();

		// Set the various attributes for Speak
		speak.setLanguage("en-US");
		speak.setVoice("WOMAN");

		// Set attributes for GetDigits
		getdigits.setAction("http://myserverurl/input/");
		getdigits.setMethod("GET");
		getdigits.setTimeout(10);
		getdigits.setDigitTimeout(5);
		getdigits.setNumDigits(4);
		getdigits.setPlayBeep(true);

		try {
			getdigits.append(speak);
			plivoXML.append(getdigits);

			String expected = TestUtils.inStreamToString(SpeakTest.class.getResourceAsStream("getdigits.xml"));

			assertEquals(expected, plivoXML.toXML());
		} catch (PlivoException e) {
			fail(e.getLocalizedMessage());
		}
	}
}
