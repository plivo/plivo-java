package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "emphasis")
public class Emphasis extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String level;

  public Emphasis() {
  }

  public Emphasis(String content) {
    this.content = content;
  }

  public Emphasis(String content, String level) {
    this.content = content;
    this.level = level;
  }

  public String getLevel() {
    return this.level;
  }
}
