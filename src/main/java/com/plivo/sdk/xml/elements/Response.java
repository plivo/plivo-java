package com.plivo.sdk.xml.elements;

import java.io.Serializable;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response implements Serializable {

    private static final long serialVersionUID = 8071673898735283084L;

    @XmlElement(name="Speak")
    private Speak speak;

    @XmlElement(name="Play")
    private Play play;

    @XmlElement(name="GetDigits")
    private GetDigits getDigits;

    @XmlElement(name="Record")
    private Record record;

    @XmlElement(name="Dial")
    private Dial dial;

    @XmlElement(name="Redirect")
    private Redirect redirect;

    @XmlElement(name="Wait")
    private Wait wait;

    @XmlElement(name="Hangup")
    private Hangup hangup;

    @XmlElement(name="PreAnswer")
    private PreAnswer preAnswer;

    @XmlElement(name="Conference")
    private Conference conference;

    @XmlElement(name="Message")
    private Message message;

    public Response() {

    }

    public Speak getSpeak() {
        return speak;
    }

    public void setSpeak(Speak speak) {
        this.speak = speak;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public GetDigits getGetDigits() {
        return getDigits;
    }

    public void setGetDigits(GetDigits getDigits) {
        this.getDigits = getDigits;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Dial getDial() {
        return dial;
    }

    public void setDial(Dial dial) {
        this.dial = dial;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public Wait getWait() {
        return wait;
    }

    public void setWait(Wait wait) {
        this.wait = wait;
    }

    public Hangup getHangup() {
        return hangup;
    }

    public void setHangup(Hangup hangup) {
        this.hangup = hangup;
    }

    public PreAnswer getPreAnswer() {
        return preAnswer;
    }

    public void setPreAnswer(PreAnswer preAnswer) {
        this.preAnswer = preAnswer;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    public String serializeToXML() {
        StringWriter writer = new StringWriter();
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
            jaxbContext.createMarshaller().marshal(this, writer);
        } catch (JAXBException e) {
            return "<Response/>";
        }
        return writer.toString();
    }
}