package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "sub")
public class Sub extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String alias;

  public Sub() {
  }

  public Sub(String content) {
    this.content = content;
  }

  public Sub(String content, String alias) {
    this.content = content;
    this.alias = alias;
  }

  public String getAlias() {
    return this.alias;
  }
}
