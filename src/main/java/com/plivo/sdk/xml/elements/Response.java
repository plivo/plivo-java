package com.plivo.sdk.xml.elements;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;

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
    private ArrayList<Speak> speakFactory;

    @XmlElement(name="Play")
    private ArrayList<Play> playFactory;

    @XmlElement(name="GetDigits")
    private ArrayList<GetDigits> getDigitsFactory;

    @XmlElement(name="Record")
    private ArrayList<Record> recordFactory;

    @XmlElement(name="Dial")
    private ArrayList<Dial> dialFactory;

    @XmlElement(name="Redirect")
    private ArrayList<Redirect> redirectFactory;

    @XmlElement(name="Wait")
    private ArrayList<Wait> waitFactory;

    @XmlElement(name="Hangup")
    private ArrayList<Hangup> hangupFactory;

    @XmlElement(name="PreAnswer")
    private ArrayList<PreAnswer> preAnswerFactory;

    @XmlElement(name="Conference")
    private ArrayList<Conference> conferenceFactory;

    @XmlElement(name="Message")
    private ArrayList<Message> messageFactory;

    public Response() {
		speakFactory = new ArrayList<Speak>();
		playFactory = new ArrayList<Play>();
		getDigitsFactory = new ArrayList<GetDigits>();
		recordFactory = new ArrayList<Record>();
		dialFactory = new ArrayList<Dial>();
		redirectFactory = new ArrayList<Redirect>();
		waitFactory = new ArrayList<Wait>();
		hangupFactory = new ArrayList<Hangup>();
		preAnswerFactory = new ArrayList<PreAnswer>();
		conferenceFactory = new ArrayList<Conference>();
		messageFactory = new ArrayList<Message>();
    }

    public void addSpeak(Speak speak) {
        this.speakFactory.add(speak);
    }

    public void addPlay(Play play) {
        this.playFactory.add(play);
    }

    public void addGetDigits(GetDigits getDigits) {
        this.getDigitsFactory.add(getDigits);
    }

    public void addRecord(Record record) {
        this.recordFactory.add(record);
    }

    public void addDial(Dial dial) {
        this.dialFactory.add(dial);
    }

    public void addRedirect(Redirect redirect) {
        this.redirectFactory.add(redirect);
    }

    public void addWait(Wait wait) {
        this.waitFactory.add(wait);
    }

    public void addHangup(Hangup hangup) {
        this.hangupFactory.add(hangup);
    }

    public void addPreAnswer(PreAnswer preAnswer) {
        this.preAnswerFactory.add(preAnswer);
    }

    public void addConference(Conference conference) {
        this.conferenceFactory.add(conference);
    }

    public void addMessage(Message message) {
        this.messageFactory.add(message);
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
