package com.plivo.helper.xml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.plivo.helper.exception.PlivoException;

public class RecordTest {
	@Test
	public void testMessage() {
		PlivoXML plivoXML = new PlivoXML();
		Record rec = new Record();
		rec.setAction("http://safe-stream-4972.herokuapp.com/incall/recvoicemail/action");
		rec.setMethod("GET");
		try {
			plivoXML.append(rec);
			String expected = TestUtils.inStreamToString(RecordTest.class
					.getResourceAsStream("record.xml"));
			assertEquals(expected, plivoXML.toXML());
		} catch (PlivoException pe) {
			fail(pe.getMessage());
		}
	}
}
