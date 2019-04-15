package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "w")
public class W extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String role;

  public W() {
  }

  public W(String content) {
    this.content = content;
  }

  public W(String content, String role) {
    this.content = content;
    this.role = role;
  }

  public String getRole() {
    return this.role;
  }
}
