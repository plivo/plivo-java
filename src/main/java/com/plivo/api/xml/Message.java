package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Message")
public class Message extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String src;

  @XmlAttribute
  private String dst;

  @XmlAttribute
  private String type;

  public String content() {
    return this.content;
  }

  public String src() {
    return this.src;
  }

  public String dst() {
    return this.dst;
  }

  public String type() {
    return this.type;
  }

  public Message content(final String content) {
    this.content = content;
    return this;
  }

  public Message src(final String src) {
    this.src = src;
    return this;
  }

  public Message dst(final String dst) {
    this.dst = dst;
    return this;
  }

  public Message type(final String type) {
    this.type = type;
    return this;
  }


  @XmlAttribute
  private String callbackUrl;

  @XmlAttribute
  private String callbackMethod;

  public Message(String src, String dst, String content) {
    this.src = src;
    this.dst = dst;
    this.content = content;
  }

  private Message() {
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }

  public Message callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public Message callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }
}
