package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlMixed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.plivo.api.exceptions.PlivoXmlException;

@XmlRootElement(name = "emphasis")
public class Emphasis extends PlivoXml implements EmphasisNestable,
                                                  LangNestable,
                                                  PNestable,
                                                  ProsodyNestable,
                                                  SNestable,
                                                  SpeakNestable,
                                                  WNestable {

  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

  @XmlAttribute
  private String level;

  public Emphasis() {
  }

  public Emphasis(String content) {
    this.mixedContent.add(content);
  }

  public Emphasis(String content, String level) {
    this.mixedContent.add(content);
    this.level = level;
  }

  public String getLevel() {
    return this.level;
  }

  public Emphasis children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof EmphasisNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <emphasis>");
      }
    }
    return this;
  }
}
