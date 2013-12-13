package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class SpeakTest {
	@Test
	public void testSpeak() {
		PlivoResponse response = new PlivoResponse();
    	Speak speak = new Speak("Plivo calling.");

    	speak.setLanguage("en-US");
        speak.setVoice("WOMAN");
        speak.setLoop(3);

        try {
            response.append(speak);
            String expected = TestUtils.inStreamToString(SpeakTest.class.getResourceAsStream("speak.xml"));
            assertEquals(expected, response.toXML());
        } catch (PlivoException e) {
            fail(e.getLocalizedMessage());
        }
	}
}