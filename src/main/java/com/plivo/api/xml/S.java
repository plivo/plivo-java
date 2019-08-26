package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "s")
public class S extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  public S() {
  }

  public S(String content) {
    this.content = content;
  }
}
