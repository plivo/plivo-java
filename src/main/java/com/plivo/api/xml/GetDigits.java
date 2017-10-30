package com.plivo.api.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetDigits")
public class GetDigits extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String action;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private Integer timeout;

  @XmlAttribute
  private Integer digitTimeout;

  @XmlAttribute
  private String finishOnKey;

  @XmlAttribute
  private Integer numDigits;

  @XmlAttribute
  private Integer retries;

  @XmlAttribute
  private Boolean redirect;

  @XmlAttribute
  private String validDigits;

  @XmlAttribute
  private Boolean playBeep;

  @XmlAttribute
  private String invalidDigitsSound;

  @XmlAttribute
  private Boolean log;

  @XmlElements({
    @XmlElement(name = "Speak", type = Speak.class),
    @XmlElement(name = "Play", type = Play.class)
  })
  private List<GetDigitsNestable> children = new ArrayList<>();

  public String action() {
    return this.action;
  }

  public String method() {
    return this.method;
  }

  public Integer timeout() {
    return this.timeout;
  }

  public Integer digitTimeout() {
    return this.digitTimeout;
  }

  public String finishOnKey() {
    return this.finishOnKey;
  }

  public Integer numDigits() {
    return this.numDigits;
  }

  public Integer retries() {
    return this.retries;
  }

  public Boolean redirect() {
    return this.redirect;
  }

  public String validDigits() {
    return this.validDigits;
  }

  public Boolean playBeep() {
    return this.playBeep;
  }

  public String invalidDigitsSound() {
    return this.invalidDigitsSound;
  }

  public Boolean log() {
    return this.log;
  }

  public List<GetDigitsNestable> children() {
    return this.children;
  }

  public GetDigits action(final String action) {
    this.action = action;
    return this;
  }

  public GetDigits method(final String method) {
    this.method = method;
    return this;
  }

  public GetDigits timeout(final Integer timeout) {
    this.timeout = timeout;
    return this;
  }

  public GetDigits digitTimeout(final Integer digitTimeout) {
    this.digitTimeout = digitTimeout;
    return this;
  }

  public GetDigits finishOnKey(final String finishOnKey) {
    this.finishOnKey = finishOnKey;
    return this;
  }

  public GetDigits numDigits(final Integer numDigits) {
    this.numDigits = numDigits;
    return this;
  }

  public GetDigits retries(final Integer retries) {
    this.retries = retries;
    return this;
  }

  public GetDigits redirect(final Boolean redirect) {
    this.redirect = redirect;
    return this;
  }

  public GetDigits validDigits(final String validDigits) {
    this.validDigits = validDigits;
    return this;
  }

  public GetDigits playBeep(final Boolean playBeep) {
    this.playBeep = playBeep;
    return this;
  }

  public GetDigits invalidDigitsSound(final String invalidDigitsSound) {
    this.invalidDigitsSound = invalidDigitsSound;
    return this;
  }

  public GetDigits log(final Boolean log) {
    this.log = log;
    return this;
  }

  public GetDigits children(GetDigitsNestable... children) {
    this.children.addAll(Arrays.asList(children));
    return this;
  }
}
