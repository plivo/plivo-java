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

			String expected = TestUtils.inStreamToString(SpeakTest.class
					.getResourceAsStream("getdigits.xml"));

			assertEquals(expected, plivoXML.toXML());
		} catch (PlivoException e) {
			fail(e.getLocalizedMessage());
		}
	}

	/**
	 * Test getDigits element with speak element inside of it
	 */
	public void testGetDigitsSpeak() {
		PlivoXML plivoXML = new PlivoXML();

		GetDigits gd = new GetDigits();

		gd.setAction("http://safe-stream-4972.herokuapp.com/incall/chooselang/getdigits");
		gd.setMethod("GET");
		gd.setTimeout(20);
		gd.setNumDigits(1);

		Speak speak = new Speak(
				"Welcome to Plivo Demo app. Press 1 to hear welcome in english, press 2 to hear it in french");

		Speak timeout = new Speak(
				"Sorry, I didn't catch that. Please hangup the call and try again later.");
		try {
			gd.append(speak);
			plivoXML.append(gd);
			plivoXML.append(timeout);
			String expected = TestUtils.inStreamToString(SpeakTest.class
					.getResourceAsStream("getdigits_speak.xml"));

			assertEquals(expected, plivoXML.toXML());
		} catch (PlivoException pe) {
			fail(pe.getLocalizedMessage());
		}
	}
}
