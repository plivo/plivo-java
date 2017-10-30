package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Redirect")
public class Redirect extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String method;

  @XmlValue
  private String url;

  public Redirect(String url) {
    this.url = url;
  }

  private Redirect() {
  }

  public String method() {
    return this.method;
  }

  public Redirect method(final String method) {
    this.method = method;
    return this;
  }
}
