package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "lang")
public class Lang extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute(name="xml:lang")
  private String xmllang;

  public Lang() {
  }

  public Lang(String content) {
    this.content = content;
  }

  public Lang(String content, String xmllang) {
    this.content = content;
    this.xmllang = xmllang;
  }

  public String getXmllang() {
    return this.xmllang;
  }
}
