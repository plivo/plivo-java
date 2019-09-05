package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.plivo.api.exceptions.PlivoXmlException;
import com.plivo.api.util.Utils;

@XmlRootElement(name = "Speak")
@XmlSeeAlso({Lang.class,
      Emphasis.class,
      Break.class,
      SayAs.class,
      Sub.class,
      S.class,
      W.class,
      P.class,
      Phoneme.class,
      Prosody.class,
      })
public class Speak extends PlivoXml implements ResponseNestable, PreAnswerNestable, GetDigitsNestable {

  //public String content;
  @XmlMixed
  private List<Object> mixedContent = new ArrayList<Object>();

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
    this.mixedContent.add(content);
  }

  public Speak(String content, String voice, String language, Integer loop) throws PlivoXmlException {

    this.mixedContent.add(content);
    this.voice = voice;
    this.language = language;
    this.loop = loop;

    if (voice == null || voice.trim().isEmpty()){
    	this.voice = "WOMAN";
    	return;
    }
    if (voice.equalsIgnoreCase("MAN") || voice.equalsIgnoreCase("WOMAN")) {
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

  public Speak addBreak(String strength, String time) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new Break(strength, time));
    return this;
  }

  public Speak addEmphasis(String content, String level) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new Emphasis(content, level));
    return this;
  }

  public Speak addLang(String content, String xmllang) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new Lang(content, xmllang));
    return this;
  }

  public Speak addP(String content) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new P(content));
    return this;
  }

  public Speak addPhoneme(String content, String alphabet, String ph) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new Phoneme(content, alphabet, ph));
    return this;
  }

  public Speak addProsody(String content, String volume, String rate, String pitch) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new Prosody(content, volume, rate, pitch));
    return this;
  }

  public Speak addS(String content) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new S(content));
    return this;
  }

  public Speak addSayAs(String content, String interpretAs, String format) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new SayAs(content, interpretAs, format));
    return this;
  }

  public Speak addSub(String content, String alias) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new Sub(content, alias));
    return this;
  }

  public Speak addW(String content, String role) throws PlivoXmlException {
  	this.checkIsSSMLSupported();
    this.mixedContent.add(new W(content, role));
    return this;
  }

  public Speak continueSpeak(String content) throws PlivoXmlException {
    this.mixedContent.add(content);
    return this;
  }

  public Speak children(Object... nestables) throws PlivoXmlException {
    for (Object obj : nestables) {
      if (obj instanceof SpeakNestable || obj instanceof String) {
        mixedContent.add(obj);
      } else {
        throw new PlivoXmlException("XML Validation Error: <" + obj.getClass().getSimpleName() + "> can not be nested in <Speak>");
      }
    }
    return this;
  }
}
