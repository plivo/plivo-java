package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Play")
public class Play extends PlivoXml implements ResponseNestable, PreAnswerNestable, GetDigitsNestable, GetInputNestable {

  @XmlAttribute
  private Integer loop;

  @XmlValue
  private String url;

  public Play(String url) {
    this.url = url;
  }

  private Play() {
  }

  public Integer loop() {
    return this.loop;
  }

  public Play loop(final Integer loop) {
    this.loop = loop;
    return this;
  }
}
