package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "p")
public class P extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  public P() {
  }

  public P(String content) {
    this.content = content;
  }
}
