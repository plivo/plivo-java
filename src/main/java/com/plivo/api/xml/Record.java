package com.plivo.api.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Record")
public class Record extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String action;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private String fileFormat;

  @XmlAttribute
  private Boolean redirect;

  @XmlAttribute
  private Integer timeout;

  @XmlAttribute
  private Integer maxLength;

  @XmlAttribute
  private Boolean playBeep;

  @XmlAttribute
  private String finishOnKey;

  @XmlAttribute
  private Boolean recordSession;

  @XmlAttribute
  private Boolean startOnDialAnswer;

  @XmlAttribute
  private String transcriptionType;

  @XmlAttribute
  private String transcriptionUrl;

  @XmlAttribute
  private String transcriptionMethod;

  @XmlAttribute
  private String callbackUrl;

  @XmlAttribute
  private String callbackMethod;

  public Record(String action) {
    this.action = action;
  }

  private Record() {
  }

  public String method() {
    return this.method;
  }

  public String fileFormat() {
    return this.fileFormat;
  }

  public Boolean redirect() {
    return this.redirect;
  }

  public Integer timeout() {
    return this.timeout;
  }

  public Integer maxLength() {
    return this.maxLength;
  }

  public Boolean playBeep() {
    return this.playBeep;
  }

  public String finishOnKey() {
    return this.finishOnKey;
  }

  public Boolean recordSession() {
    return this.recordSession;
  }

  public Boolean startOnDialAnswer() {
    return this.startOnDialAnswer;
  }

  public String transcriptionType() {
    return this.transcriptionType;
  }

  public String transcriptionUrl() {
    return this.transcriptionUrl;
  }

  public String transcriptionMethod() {
    return this.transcriptionMethod;
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }

  public Record method(final String method) {
    this.method = method;
    return this;
  }

  public Record fileFormat(final String fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  public Record redirect(final Boolean redirect) {
    this.redirect = redirect;
    return this;
  }

  public Record timeout(final Integer timeout) {
    this.timeout = timeout;
    return this;
  }

  public Record maxLength(final Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

  public Record playBeep(final Boolean playBeep) {
    this.playBeep = playBeep;
    return this;
  }

  public Record finishOnKey(final String finishOnKey) {
    this.finishOnKey = finishOnKey;
    return this;
  }

  public Record recordSession(final Boolean recordSession) {
    this.recordSession = recordSession;
    return this;
  }

  public Record startOnDialAnswer(final Boolean startOnDialAnswer) {
    this.startOnDialAnswer = startOnDialAnswer;
    return this;
  }

  public Record transcriptionType(final String transcriptionType) {
    this.transcriptionType = transcriptionType;
    return this;
  }

  public Record transcriptionUrl(final String transcriptionUrl) {
    this.transcriptionUrl = transcriptionUrl;
    return this;
  }

  public Record transcriptionMethod(final String transcriptionMethod) {
    this.transcriptionMethod = transcriptionMethod;
    return this;
  }

  public Record callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public Record callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }
}
