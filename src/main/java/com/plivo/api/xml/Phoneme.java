package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "phoneme")
public class Phoneme extends PlivoXml implements ResponseNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String alphabet;

  @XmlAttribute
  private String ph;

  public Phoneme() {
  }

  public Phoneme(String content) {
    this.content = content;
  }

  public Phoneme(String content, String alphabet, String ph) {
    this.content = content;
    this.alphabet = alphabet;
    this.ph = ph;
  }

  public String getAlphabet() {
    return this.alphabet;
  }

  public String getPh() {
    return this.ph;
  }
}
