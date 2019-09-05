package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "break")
public class Break extends PlivoXml implements EmphasisNestable,
                                               LangNestable,
                                               PNestable,
                                               ProsodyNestable,
                                               SNestable,
                                               SpeakNestable,
                                               WNestable {

  @XmlAttribute
  private String strength;

  @XmlAttribute
  private String time;

  public Break() {
  }

  public Break(String strength, String time) {
    this.strength = strength;
    this.time = time;
  }

  public String getStrength() {
    return this.strength;
  }

  public String getTime() {
    return this.time;
  }
}
