package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Speak")
public class Speak extends PlivoXml implements ResponseNestable, PreAnswerNestable, GetDigitsNestable {

  @XmlValue
  private String content;

  public Speak(String content) {
    this.content = content;
  }

  private Speak() {}

  @XmlAttribute
  private String voice;

  @XmlAttribute
  private String language;

  @XmlAttribute
  private Integer loop;

  public String voice() {
    return this.voice;
  }

  public String language() {
    return this.language;
  }

  public Integer loop() {
    return this.loop;
  }

  public Speak voice(final String voice) {
    this.voice = voice;
    return this;
  }

  public Speak language(final String language) {
    this.language = language;
    return this;
  }

  public Speak loop(final Integer loop) {
    this.loop = loop;
    return this;
  }
}
