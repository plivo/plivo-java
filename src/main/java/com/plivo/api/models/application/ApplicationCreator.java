package com.plivo.api.models.application;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class ApplicationCreator extends Creator<ApplicationCreateResponse> {

  private String appName;
  private String answerUrl;
  private String answerMethod;
  private String hangupUrl;
  private String hangupMethod;
  private String fallbackAnswerUrl;
  private String fallbackMethod;
  private String messageUrl;
  private String messageMethod;
  private Boolean defaultNumberApp;
  private Boolean defaultEndpointApp;
  private String subaccount;

  /**
   * @param appName The name of your application
   */
  ApplicationCreator(String appName) {
    if (!Utils.allNotNull(appName)) {
      throw new IllegalArgumentException("appName and answerUrl must not be null");
    }

    this.appName = appName;
  }

  public String appName() {
    return this.appName;
  }

  public String answerUrl() {
    return this.answerUrl;
  }

  public String answerMethod() {
    return this.answerMethod;
  }

  public String hangupUrl() {
    return this.hangupUrl;
  }

  public String hangupMethod() {
    return this.hangupMethod;
  }

  public String fallbackAnswerUrl() {
    return this.fallbackAnswerUrl;
  }

  public String fallbackMethod() {
    return this.fallbackMethod;
  }

  public String messageUrl() {
    return this.messageUrl;
  }

  public String messageMethod() {
    return this.messageMethod;
  }

  public Boolean defaultNumberApp() {
    return this.defaultNumberApp;
  }

  public Boolean defaultEndpointApp() {
    return this.defaultEndpointApp;
  }

  public String subaccount() {
    return this.subaccount;
  }

  public ApplicationCreator appName(final String appName) {
    this.appName = appName;
    return this;
  }

  public ApplicationCreator answerUrl(final String answerUrl) {
    this.answerUrl = answerUrl;
    return this;
  }

  public ApplicationCreator answerMethod(final String answerMethod) {
    this.answerMethod = answerMethod;
    return this;
  }

  public ApplicationCreator hangupUrl(final String hangupUrl) {
    this.hangupUrl = hangupUrl;
    return this;
  }

  public ApplicationCreator hangupMethod(final String hangupMethod) {
    this.hangupMethod = hangupMethod;
    return this;
  }

  public ApplicationCreator fallbackAnswerUrl(final String fallbackAnswerUrl) {
    this.fallbackAnswerUrl = fallbackAnswerUrl;
    return this;
  }

  public ApplicationCreator fallbackMethod(final String fallbackMethod) {
    this.fallbackMethod = fallbackMethod;
    return this;
  }

  public ApplicationCreator messageUrl(final String messageUrl) {
    this.messageUrl = messageUrl;
    return this;
  }

  public ApplicationCreator messageMethod(final String messageMethod) {
    this.messageMethod = messageMethod;
    return this;
  }

  public ApplicationCreator defaultNumberApp(final Boolean defaultNumberApp) {
    this.defaultNumberApp = defaultNumberApp;
    return this;
  }

  public ApplicationCreator defaultEndpointApp(final Boolean defaultEndpointApp) {
    this.defaultEndpointApp = defaultEndpointApp;
    return this;
  }

  public ApplicationCreator subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  @Override
  protected Call<ApplicationCreateResponse> obtainCall() {
    return client().getApiService().applicationCreate(client().getAuthId(), this);
  }
}
