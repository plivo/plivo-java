package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Conference")
public class Conference extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private Boolean muted;

  @XmlAttribute
  private String enterSound;

  @XmlAttribute
  private String exitSound;

  @XmlAttribute
  private Boolean startConferenceOnEnter;

  @XmlAttribute
  private Boolean endConferenceOnExit;

  @XmlAttribute
  private Boolean stayAlone;

  @XmlAttribute
  private String waitSound;

  @XmlAttribute
  private Integer maxMembers;

  @XmlAttribute
  private Boolean record;

  @XmlAttribute
  private String recordFileFormat;

  @XmlAttribute
  private Integer timeLimit;

  @XmlAttribute
  private Boolean hangupOnStar;

  @XmlAttribute
  private String action;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private String callbackUrl;

  @XmlAttribute
  private String callbackMethod;

  @XmlAttribute
  private String digitsMatch;

  @XmlAttribute
  private Boolean floorEvent;

  @XmlAttribute
  private Boolean redirect;

  @XmlAttribute(name = "relayDTMF")
  private Boolean relayDtmf;

  @XmlValue
  private String conferenceName;

  private Conference() {
  }

  public Conference(String conferenceName) {
    if (conferenceName == null) {
      throw new IllegalArgumentException("conferenceName cannot be null");
    }

    this.conferenceName = conferenceName;
  }

  public Boolean muted() {
    return this.muted;
  }

  public String enterSound() {
    return this.enterSound;
  }

  public String exitSound() {
    return this.exitSound;
  }

  public Boolean startConferenceOnEnter() {
    return this.startConferenceOnEnter;
  }

  public Boolean endConferenceOnExit() {
    return this.endConferenceOnExit;
  }

  public Boolean stayAlone() {
    return this.stayAlone;
  }

  public String waitSound() {
    return this.waitSound;
  }

  public Integer maxMembers() {
    return this.maxMembers;
  }

  public Boolean record() {
    return this.record;
  }

  public String recordFileFormat() {
    return this.recordFileFormat;
  }

  public Integer timeLimit() {
    return this.timeLimit;
  }

  public Boolean hangupOnStar() {
    return this.hangupOnStar;
  }

  public String action() {
    return this.action;
  }

  public String method() {
    return this.method;
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }

  public String digitsMatch() {
    return this.digitsMatch;
  }

  public Boolean floorEvent() {
    return this.floorEvent;
  }

  public Boolean redirect() {
    return this.redirect;
  }

  public Boolean relayDtmf() {
    return this.relayDtmf;
  }

  public Conference muted(final Boolean muted) {
    this.muted = muted;
    return this;
  }

  public Conference enterSound(final String enterSound) {
    this.enterSound = enterSound;
    return this;
  }

  public Conference exitSound(final String exitSound) {
    this.exitSound = exitSound;
    return this;
  }

  public Conference startConferenceOnEnter(final Boolean startConferenceOnEnter) {
    this.startConferenceOnEnter = startConferenceOnEnter;
    return this;
  }

  public Conference endConferenceOnExit(final Boolean endConferenceOnExit) {
    this.endConferenceOnExit = endConferenceOnExit;
    return this;
  }

  public Conference stayAlone(final Boolean stayAlone) {
    this.stayAlone = stayAlone;
    return this;
  }

  public Conference waitSound(final String waitSound) {
    this.waitSound = waitSound;
    return this;
  }

  public Conference maxMembers(final Integer maxMembers) {
    this.maxMembers = maxMembers;
    return this;
  }

  public Conference record(final Boolean record) {
    this.record = record;
    return this;
  }

  public Conference recordFileFormat(final String recordFileFormat) {
    this.recordFileFormat = recordFileFormat;
    return this;
  }

  public Conference timeLimit(final Integer timeLimit) {
    this.timeLimit = timeLimit;
    return this;
  }

  public Conference hangupOnStar(final Boolean hangupOnStar) {
    this.hangupOnStar = hangupOnStar;
    return this;
  }

  public Conference action(final String action) {
    this.action = action;
    return this;
  }

  public Conference method(final String method) {
    this.method = method;
    return this;
  }

  public Conference callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public Conference callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  public Conference digitsMatch(final String digitsMatch) {
    this.digitsMatch = digitsMatch;
    return this;
  }

  public Conference floorEvent(final Boolean floorEvent) {
    this.floorEvent = floorEvent;
    return this;
  }

  public Conference redirect(final Boolean redirect) {
    this.redirect = redirect;
    return this;
  }

  public Conference relayDtmf(final Boolean relayDtmf) {
    this.relayDtmf = relayDtmf;
    return this;
  }
}
