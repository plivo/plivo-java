package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class PlayTest {
	@Test
	public void testPlay() {
		PlivoXML plivoXML = new PlivoXML();
		Play play = new Play("https://s3.amazonaws.com/plivocloud/Trumpet.mp3");
		play.setLoop(5);
		try {
			plivoXML.append(play);
			String expected = TestUtils.inStreamToString(MessageTest.class
					.getResourceAsStream("play.xml"));
			assertEquals(expected, plivoXML.toXML());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
}
