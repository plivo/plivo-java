package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlMixed;
import java.util.List;
import com.plivo.api.exceptions.PlivoXmlException;

@XmlRootElement(name = "p")
public class P extends PlivoXml implements LangNestable,
                                           ProsodyNestable,
                                           SpeakNestable {

  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

  public P() {
  }

  public P(String content) {
    this.mixedContent.add(content);
  }

  public P children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof PNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <p>");
      }
    }
    return this;
  }
}
