package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hangup")
public class Hangup extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String reason;

  @XmlAttribute
  private Integer schedule;

  public String reason() {
    return this.reason;
  }

  public Integer schedule() {
    return this.schedule;
  }

  public Hangup reason(final String reason) {
    this.reason = reason;
    return this;
  }

  public Hangup schedule(final Integer schedule) {
    this.schedule = schedule;
    return this;
  }
}
