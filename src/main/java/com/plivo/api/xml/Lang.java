package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlMixed;
import com.plivo.api.exceptions.PlivoXmlException;

@XmlRootElement(name = "lang")
public class Lang extends PlivoXml implements EmphasisNestable,
                                              LangNestable,
                                              PNestable,
                                              ProsodyNestable,
                                              SNestable,
                                              SpeakNestable {

  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

  @XmlAttribute(name="xml:lang")
  private String xmllang;

  public Lang() {
  }

  public Lang(String content) {
    this.mixedContent.add(content);
  }

  public Lang(String content, String xmllang) {
    this.mixedContent.add(content);
    this.xmllang = xmllang;
  }

  public String getXmllang() {
    return this.xmllang;
  }

  public Lang children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof LangNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <lang>");
      }
    }
    return this;
  }
}
