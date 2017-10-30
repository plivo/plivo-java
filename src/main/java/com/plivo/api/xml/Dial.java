package com.plivo.api.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dial")
public class Dial extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String action;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private Boolean hangupOnStar;

  @XmlAttribute
  private Integer timeLimit;

  @XmlAttribute
  private Integer timeout;

  @XmlAttribute
  private String callerId;

  @XmlAttribute
  private String callerName;

  @XmlAttribute
  private String confirmSound;

  @XmlAttribute
  private String confirmKey;

  @XmlAttribute
  private String dialMusic;

  @XmlAttribute
  private String callbackUrl;

  @XmlAttribute
  private String callbackMethod;

  @XmlAttribute
  private Boolean redirect;

  @XmlAttribute
  private String digitsMatch;

  @XmlAttribute
  private String digitsMatchBLeg;

  @XmlAttribute
  private String sipHeaders;

  public String action() {
    return this.action;
  }

  public String method() {
    return this.method;
  }

  public Boolean hangupOnStar() {
    return this.hangupOnStar;
  }

  public Integer timeLimit() {
    return this.timeLimit;
  }

  public Integer timeout() {
    return this.timeout;
  }

  public String callerId() {
    return this.callerId;
  }

  public String callerName() {
    return this.callerName;
  }

  public String confirmSound() {
    return this.confirmSound;
  }

  public String confirmKey() {
    return this.confirmKey;
  }

  public String dialMusic() {
    return this.dialMusic;
  }

  public String callbackUrl() {
    return this.callbackUrl;
  }

  public String callbackMethod() {
    return this.callbackMethod;
  }

  public Boolean redirect() {
    return this.redirect;
  }

  public String digitsMatch() {
    return this.digitsMatch;
  }

  public String digitsMatchBLeg() {
    return this.digitsMatchBLeg;
  }

  public String sipHeaders() {
    return this.sipHeaders;
  }

  public List<DialNestable> children() {
    return this.children;
  }

  public Dial action(final String action) {
    this.action = action;
    return this;
  }

  public Dial method(final String method) {
    this.method = method;
    return this;
  }

  public Dial hangupOnStar(final Boolean hangupOnStar) {
    this.hangupOnStar = hangupOnStar;
    return this;
  }

  public Dial timeLimit(final Integer timeLimit) {
    this.timeLimit = timeLimit;
    return this;
  }

  public Dial timeout(final Integer timeout) {
    this.timeout = timeout;
    return this;
  }

  public Dial callerId(final String callerId) {
    this.callerId = callerId;
    return this;
  }

  public Dial callerName(final String callerName) {
    this.callerName = callerName;
    return this;
  }

  public Dial confirmSound(final String confirmSound) {
    this.confirmSound = confirmSound;
    return this;
  }

  public Dial confirmKey(final String confirmKey) {
    this.confirmKey = confirmKey;
    return this;
  }

  public Dial dialMusic(final String dialMusic) {
    this.dialMusic = dialMusic;
    return this;
  }

  public Dial callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public Dial callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  public Dial redirect(final Boolean redirect) {
    this.redirect = redirect;
    return this;
  }

  public Dial digitsMatch(final String digitsMatch) {
    this.digitsMatch = digitsMatch;
    return this;
  }

  public Dial digitsMatchBLeg(final String digitsMatchBLeg) {
    this.digitsMatchBLeg = digitsMatchBLeg;
    return this;
  }

  public Dial sipHeaders(final String sipHeaders) {
    this.sipHeaders = sipHeaders;
    return this;
  }

  public Dial children(final List<DialNestable> children) {
    this.children = children;
    return this;
  }


  @XmlElements({
    @javax.xml.bind.annotation.XmlElement(name = "Number", type = Number.class),
    @javax.xml.bind.annotation.XmlElement(name = "User", type = User.class)
  })
  private List<DialNestable> children = new ArrayList<>();

  public Dial children(DialNestable... nestables) {
    children.addAll(Arrays.asList(nestables));
    return this;
  }
}
