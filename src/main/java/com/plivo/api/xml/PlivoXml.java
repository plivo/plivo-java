package com.plivo.api.xml;

import com.plivo.api.exceptions.PlivoXmlException;
import java.io.StringWriter;
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
      marshaller.marshal(this, stringWriter);
      return stringWriter.toString();
    } catch (JAXBException e) {
      e.printStackTrace();
      throw new PlivoXmlException(e.getMessage());
    }
  }
}
