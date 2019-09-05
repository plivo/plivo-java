package com.plivo.api.xml;

import com.plivo.api.exceptions.PlivoXmlException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "w")
public class W extends PlivoXml implements EmphasisNestable,
                                           LangNestable,
                                           PNestable,
                                           ProsodyNestable,
                                           SNestable,
                                           SpeakNestable {

  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

  @XmlAttribute
  private String role;

  public W() {
  }

  public W(String content) {
    this.mixedContent.add(content);
  }

  public W(String content, String role) {
    this.mixedContent.add(content);
    this.role = role;
  }

  public String getRole() {
    return this.role;
  }

  public W children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof WNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <w>");
      }
    }
    return this;
  }
}
