package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlMixed;
import java.util.List;
import com.plivo.api.exceptions.PlivoXmlException;

@XmlRootElement(name = "prosody")
public class Prosody extends PlivoXml implements EmphasisNestable,
                                                 LangNestable,
                                                 PNestable,
                                                 ProsodyNestable,
                                                 SNestable,
                                                 SpeakNestable,
                                                 WNestable {

  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

  @XmlAttribute
  private String volume;

  @XmlAttribute
  private String rate;

  @XmlAttribute
  private String pitch;

  public Prosody() {
  }

  public Prosody(String content) {
    this.mixedContent.add(content);
  }

  public Prosody(String content, String volume, String rate, String pitch) {
    this.mixedContent.add(content);
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

  public Prosody children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof ProsodyNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <prosody>");
      }
    }
    return this;
  }
}
