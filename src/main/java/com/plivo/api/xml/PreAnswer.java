package com.plivo.api.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PreAnswer")
public class PreAnswer extends PlivoXml implements ResponseNestable {

  @XmlElements({
    @javax.xml.bind.annotation.XmlElement(name = "Speak", type = Speak.class),
    @javax.xml.bind.annotation.XmlElement(name = "Wait", type = Wait.class),
    @javax.xml.bind.annotation.XmlElement(name = "Play", type = Play.class)
  })
  private List<PreAnswerNestable> children = new ArrayList<>();


  public PreAnswer children(PreAnswerNestable... children) {
    this.children.addAll(Arrays.asList(children));
    return this;
  }
}
