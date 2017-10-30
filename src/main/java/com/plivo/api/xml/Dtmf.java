package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "DTMF")
public class Dtmf extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private Boolean async;

  @XmlValue
  private String content;

  public Dtmf(String content) {
    this.content = content;
  }

  private Dtmf() {
  }
}
