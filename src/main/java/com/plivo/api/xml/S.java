package com.plivo.api.xml;

import com.plivo.api.exceptions.PlivoXmlException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "s")
public class S extends PlivoXml implements LangNestable,
                                           PNestable,
                                           ProsodyNestable,
                                           SpeakNestable {

  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

  public S() {
  }

  public S(String content) {
    this.mixedContent.add(content);
  }

  public S children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof SNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <s>");
      }
    }
    return this;
  }
}
