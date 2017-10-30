package com.plivo.api.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class Response extends PlivoXml {

  @XmlElements({
    @XmlElement(name = "Wait", type = Wait.class),
    @XmlElement(name = "Dial", type = Dial.class),
    @XmlElement(name = "Conference", type = Conference.class),
    @XmlElement(name = "Message", type = Message.class),
    @XmlElement(name = "Play", type = Play.class),
    @XmlElement(name = "Speak", type = Speak.class),
    @XmlElement(name = "DTMF", type = Dtmf.class),
    @XmlElement(name = "PreAnswer", type = PreAnswer.class),
    @XmlElement(name = "Hangup", type = Hangup.class),
    @XmlElement(name = "Redirect", type = Redirect.class),
    @XmlElement(name = "GetDigits", type = GetDigits.class),
    @XmlElement(name = "Record", type = Record.class),
  })
  private List<com.plivo.api.xml.XmlElement> children = new ArrayList<>();

  public Response children(ResponseNestable... nestable) {
    children.addAll(Arrays.asList(nestable));
    return this;
  }
}
