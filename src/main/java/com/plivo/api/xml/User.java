package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "User")
public class User extends PlivoXml implements DialNestable {

  @XmlAttribute
  private String sendDigits;

  @XmlAttribute
  private Boolean sendOnPreanswer;

  @XmlAttribute
  private String sipHeaders;

  @XmlValue
  private String content;

  public User(String content) {
    this.content = content;
  }

  private User() {
  }

  public User content(String content) {
    this.content = content;
    return this;
  }

  public String sendDigits() {
    return this.sendDigits;
  }

  public Boolean sendOnPreanswer() {
    return this.sendOnPreanswer;
  }

  public String sipHeaders() {
    return this.sipHeaders;
  }

  public String content() {
    return this.content;
  }

  public User sendDigits(final String sendDigits) {
    this.sendDigits = sendDigits;
    return this;
  }

  public User sendOnPreanswer(final Boolean sendOnPreanswer) {
    this.sendOnPreanswer = sendOnPreanswer;
    return this;
  }

  public User sipHeaders(final String sipHeaders) {
    this.sipHeaders = sipHeaders;
    return this;
  }
}
