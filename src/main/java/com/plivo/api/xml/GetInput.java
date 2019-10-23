package com.plivo.api.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetInput")
public class GetInput extends PlivoXml implements ResponseNestable {

  @XmlAttribute
  private String action;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private String inputType;

  @XmlAttribute
  private Integer executionTimeout;

  @XmlAttribute
  private Integer digitEndTimeout;

  @XmlAttribute
  private Integer speechEndTimeout;

  @XmlAttribute
  private String finishOnKey;

  @XmlAttribute
  private Integer numDigits;

  @XmlAttribute
  private String speechModel;

  @XmlAttribute
  private String hints;

  @XmlAttribute
  private String language;

  @XmlAttribute
  private String interimSpeechResultsCallback;

  @XmlAttribute
  private String interimSpeechResultsCallbackMethod;

  @XmlAttribute
  private Boolean redirect;

  @XmlAttribute
  private Boolean log;

  @XmlAttribute
  private Boolean profanityFilter;

  @XmlElements({
    @XmlElement(name = "Speak", type = Speak.class),
    @XmlElement(name = "Wait", type = Wait.class)
    @XmlElement(name = "Play", type = Play.class)
  })
  private List<GetInputNestable> children = new ArrayList<>();

  public String action() {
    return this.action;
  }

  public String method() {
    return this.method;
  }

  public String inputType() {
    return this.inputType;
  }

  public Integer executionTimeout() {
    return this.executionTimeout;
  }

  public Integer digitEndTimeout() {
    return this.digitEndTimeout;
  }

  public Integer speechEndTimeout() {
    return this.speechEndTimeout;
  }

  public String finishOnKey() {
    return this.finishOnKey;
  }

  public Integer numDigits() {
    return this.numDigits;
  }

  public String speechModel() {
    return this.speechModel;
  }

  public String hints() {
    return this.hints;
  }

  public String language() {
    return this.language;
  }

  public String interimSpeechResultsCallback() {
    return this.interimSpeechResultsCallback;
  }

  public String interimSpeechResultsCallbackMethod() {
    return this.interimSpeechResultsCallbackMethod;
  }

  public Boolean redirect() {
    return this.redirect;
  }

  public Boolean log() {
    return this.log;
  }

  public Boolean profanityFilter() {
    return this.profanityFilter;
  }

  public List<GetInputNestable> children() {
    return this.children;
  }

  public GetInput action(final String action) {
    this.action = action;
    return this;
  }

  public GetInput method(final String method) {
    this.method = method;
    return this;
  }

  public GetInput inputType(final String inputType) {
    this.inputType = inputType;
    return this;
  }

  public GetInput executionTimeout(final Integer executionTimeout) {
    this.executionTimeout = executionTimeout;
    return this;
  }

  public GetInput digitEndTimeout(final Integer digitEndTimeout) {
    this.digitEndTimeout = digitEndTimeout;
    return this;
  }

  public GetInput speechEndTimeout(final Integer speechEndTimeout) {
    this.speechEndTimeout = speechEndTimeout;
    return this;
  }

  public GetInput finishOnKey(final String finishOnKey) {
    this.finishOnKey = finishOnKey;
    return this;
  }

  public GetInput numDigits(final Integer numDigits) {
    this.numDigits = numDigits;
    return this;
  }

  public GetInput speechModel(final String speechModel) {
    this.speechModel = speechModel;
    return this;
  }

  public GetInput hints(final String hints) {
    this.hints = hints;
    return this;
  }

  public GetInput language(final String language) {
    this.language = language;
    return this;
  }

  public GetInput interimSpeechResultsCallback(final String interimSpeechResultsCallback) {
    this.interimSpeechResultsCallback = interimSpeechResultsCallback;
    return this;
  }

  public GetInput interimSpeechResultsCallbackMethod(final String interimSpeechResultsCallbackMethod) {
    this.interimSpeechResultsCallbackMethod = interimSpeechResultsCallbackMethod;
    return this;
  }

  public GetInput redirect(final Boolean redirect) {
    this.redirect = redirect;
    return this;
  }

  public GetInput log(final Boolean log) {
    this.log = log;
    return this;
  }

  public GetInput profanityFilter(final Boolean profanityFilter) {
    this.profanityFilter = profanityFilter;
    return this;
  }

  public GetInput children(GetInputNestable... children) {
    this.children.addAll(Arrays.asList(children));
    return this;
  }
}
