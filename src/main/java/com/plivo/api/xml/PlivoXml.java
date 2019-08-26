package com.plivo.api.xml;

import com.plivo.api.exceptions.PlivoXmlException;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.internal.bind.marshaller.DataWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class PlivoXml {

	public String toXmlString() throws PlivoXmlException {
		return toXmlString(false);
	}

	public String toXmlString(boolean debug) throws PlivoXmlException {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(getClass());
			StringWriter stringWriter = new StringWriter();
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			if (debug) {
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			}

			// Set UTF-8 Encoding
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			// The below code will take care of avoiding the conversion of < to &lt; and > to &gt; etc
			PrintWriter printWriter = new PrintWriter(stringWriter);
			DataWriter dataWriter = new DataWriter(printWriter, "UTF-8", new JaxbCharacterEscapeHandler());

			// Perform Marshalling operation
			marshaller.marshal(this, dataWriter);

			return stringWriter.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new PlivoXmlException(e.getMessage());
		}
	}
}
