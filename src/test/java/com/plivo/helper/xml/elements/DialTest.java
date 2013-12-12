package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class DialTest {
	@Test
	public void testDial() {
		PlivoResponse response = new PlivoResponse();
        Dial dial = new Dial();
        Number number = new Number("12345678901");

        dial.setAction("http://http://myserverurl/setredirect/");
        dial.setMethod("GET");
        dial.setCallerId("12345678901");
        dial.setTimeLimit(30);
        dial.setTimeout(30);
        dial.setHangupOnStar(true);
        dial.setCallbackUrl("http://google.com");
        dial.setCallbackMethod("GET");
        dial.setCallerName("Zeus");

        try {
            dial.append(number);
            response.append(dial);

            String expected = TestUtils.inStreamToString(SpeakTest.class.getResourceAsStream("dial.xml"));
            assertEquals(expected, response.toXML());
        } catch (PlivoException e) {
            fail(e.getMessage());
        }
	}
}
