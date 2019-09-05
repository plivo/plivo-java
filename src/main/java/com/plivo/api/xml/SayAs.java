package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "say-as")
public class SayAs extends PlivoXml implements EmphasisNestable,
                                               LangNestable,
                                               PNestable,
                                               ProsodyNestable,
                                               SNestable,
                                               SpeakNestable,
                                               WNestable {

  @XmlValue
  private String content;

  @XmlAttribute(name="interpret-as")
  private String interpretAs;

  @XmlAttribute
  private String format;

  public SayAs() {
  }

  public SayAs(String content) {
    this.content = content;
  }

  public SayAs(String content, String interpretAs, String format) {
    this.content = content;
    this.interpretAs = interpretAs;
    this.format = format;
  }

  public String getInterpretAs() {
    return this.interpretAs;
  }

  public String getFormat() {
    return this.format;
  }
}
