package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "prosody")
public class Prosody extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String volume;

  @XmlAttribute
  private String rate;

  @XmlAttribute
  private String pitch;

  public Prosody() {
  }

  public Prosody(String content) {
    this.content = content;
  }

  public Prosody(String content, String volume, String rate, String pitch) {
    this.content = content;
    this.volume = volume;
    this.rate = rate;
    this.pitch = pitch;
  }

  public String getVolume() {
    return this.volume;
  }

  public String getRate() {
    return this.rate;
  }

  public String getPitch() {
    return pitch;
  }

}
