package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Wait")
public class Wait extends PlivoXml implements ResponseNestable, PreAnswerNestable {

  @XmlAttribute
  private Integer length;

  @XmlAttribute
  private Boolean silence;

  @XmlAttribute
  private Integer minSilence;

  @XmlAttribute
  private Boolean beep;

  public Integer length() {
    return this.length;
  }

  public Boolean silence() {
    return this.silence;
  }

  public Integer minSilence() {
    return this.minSilence;
  }

  public Boolean beep() {
    return this.beep;
  }

  public Wait length(final Integer length) {
    this.length = length;
    return this;
  }

  public Wait silence(final Boolean silence) {
    this.silence = silence;
    return this;
  }

  public Wait minSilence(final Integer minSilence) {
    this.minSilence = minSilence;
    return this;
  }

  public Wait beep(final Boolean beep) {
    this.beep = beep;
    return this;
  }
}
