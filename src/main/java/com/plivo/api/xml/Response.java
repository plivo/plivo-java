package com.plivo.api.xml;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.validators.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class Response extends PlivoXml {

    @XmlElements({
            @XmlElement(name = "Wait", type = Wait.class),
            @XmlElement(name = "Dial", type = Dial.class),
            @XmlElement(name = "Conference", type = Conference.class),
            @XmlElement(name = "MultiPartyCall", type = MultiPartyCall.class),
            @XmlElement(name = "Message", type = Message.class),
            @XmlElement(name = "Play", type = Play.class),
            @XmlElement(name = "Speak", type = Speak.class),
            @XmlElement(name = "DTMF", type = Dtmf.class),
            @XmlElement(name = "PreAnswer", type = PreAnswer.class),
            @XmlElement(name = "Hangup", type = Hangup.class),
            @XmlElement(name = "Redirect", type = Redirect.class),
            @XmlElement(name = "GetDigits", type = GetDigits.class),
            @XmlElement(name = "GetInput", type = GetInput.class),
            @XmlElement(name = "Record", type = Record.class),
    })
    private List<com.plivo.api.xml.XmlElement> children = new ArrayList<>();

    public Response children(ResponseNestable... nestable) throws PlivoValidationException {
    for(ResponseNestable n: nestable){
      Validate.check(n);
    }
        children.addAll(Arrays.asList(nestable));
        return this;
    }
}
