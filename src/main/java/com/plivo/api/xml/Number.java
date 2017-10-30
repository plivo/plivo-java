package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Number")
public class Number extends PlivoXml implements DialNestable {

  @XmlAttribute
  private String sendDigits;

  @XmlAttribute
  private Boolean sendOnPreanswer;

  @XmlValue
  private String content;

  public Number(String content) {
    this.content = content;
  }

  private Number() {
  }

  public String sendDigits() {
    return this.sendDigits;
  }

  public Boolean sendOnPreanswer() {
    return this.sendOnPreanswer;
  }

  public Number sendDigits(final String sendDigits) {
    this.sendDigits = sendDigits;
    return this;
  }

  public Number sendOnPreanswer(final Boolean sendOnPreanswer) {
    this.sendOnPreanswer = sendOnPreanswer;
    return this;
  }

  public String content() {
    return this.content;
  }

  public Number content(final String content) {
    this.content = content;
    return this;
  }
}
