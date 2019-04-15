package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.plivo.api.exceptions.PlivoXmlException;
import com.plivo.api.util.Utils;

@XmlRootElement(name = "Speak")
public class Speak extends PlivoXml implements ResponseNestable, PreAnswerNestable, GetDigitsNestable {

  @XmlValue
  private String content;

  @XmlAttribute
  private String voice;

  @XmlAttribute
  private String language;

  @XmlAttribute
  private Integer loop;
	
  private static int MAX_CONTENT_LENGTH = 3000;

  public Speak() {

  }

  public Speak(String content) {
    this.content = content;
  }

  public Speak(String content, String voice, String language, Integer loop) throws PlivoXmlException {
 
    this.content = content;
    this.voice = voice;
    this.language = language;
    this.loop = loop;
    
    if (voice == null || voice.trim().isEmpty()){
    	this.voice = "WOMAN";
    	this.validateLength();
    	return;
    }
    if (voice.equalsIgnoreCase("MAN") || voice.equalsIgnoreCase("WOMAN")) {
    	this.validateLength();
    	return;
    }

    this.voice = transformVoiceString(voice);
    Utils.validateLanguageVoice(language, voice);
  }

  public String getVoice() {
    return voice;
  }

  public String getLanguage() {
    return language;
  }

  public Integer getLoop() {
    return loop;
  }

  private void checkIsSSMLSupported() throws PlivoXmlException {
  	if (this.voice == null || this.voice.trim().isEmpty() ||
  			this.voice.equalsIgnoreCase("MAN") || this.voice.equalsIgnoreCase("WOMAN")) { 
  		throw new PlivoXmlException("SSML support is available only for Amazon Polly!");
    }
  }
  
  private static String transformVoiceString(String voice) {
    String[] voiceParts = voice.trim().split("\\.");
    if (voiceParts.length == 1) {
      return voice;
    }
    String voiceName = Utils.transformString(voiceParts[1]);
    return voiceParts[0] + "." + voiceName;
  }

  public Speak addBreak(String content, String strength, String time) throws PlivoXmlException {
    Break breakElement = new Break(content, strength, time);
    return this.appendChildren(breakElement.toXmlString());
  }

  public Speak addEmphasis(String content, String level) throws PlivoXmlException {
  	Emphasis emphasis = new Emphasis(content, level);
    return this.appendChildren(emphasis.toXmlString());
  }

  public Speak addLang(String content, String xmllang) throws PlivoXmlException {
  	Lang lang = new Lang(content, xmllang);
    return this.appendChildren(lang.toXmlString());
  }

  public Speak addP(String content) throws PlivoXmlException {
  	P p = new P(content);
    return this.appendChildren(p.toXmlString());
  }

  public Speak addPhoneme(String content, String alphabet, String ph) throws PlivoXmlException {
  	Phoneme phoneme = new Phoneme(content, alphabet, ph);
    return this.appendChildren(phoneme.toXmlString());
  }

  public Speak addProsody(String content, String volume, String rate, String pitch) throws PlivoXmlException {
    Prosody prosody = new Prosody(content, volume, rate, pitch);
    return this.appendChildren(prosody.toXmlString());
  }

  public Speak addS(String content) throws PlivoXmlException {
    S s = new S(content);
    return this.appendChildren(s.toXmlString());
  }

  public Speak addSayAs(String content, String interpretAs, String format) throws PlivoXmlException {
    SayAs sayAs = new SayAs(content, interpretAs, format);
    return this.appendChildren(sayAs.toXmlString());
  }

  public Speak addSub(String content, String alias) throws PlivoXmlException {
    Sub sub = new Sub(content, alias);
    return this.appendChildren(sub.toXmlString());
  }

  public Speak addW(String content, String role) throws PlivoXmlException {
    W w = new W(content, role);
    return this.appendChildren(w.toXmlString());
  }

  public Speak appendChildren(String content) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
  	this.validateLength();
    this.content += content;
    return this;
  }
  
	public Speak validateLength() throws PlivoXmlException {
		if (content.length() > MAX_CONTENT_LENGTH) {
      throw new PlivoXmlException("XML Validation Error: <Speak> text exceeds upper limit of 3000 characters.");
    }
    return this;
  }
	
  public Speak continueSpeak(String content) throws PlivoXmlException {
  	this.validateLength();
    this.content += content;
    return this;
  }
}
