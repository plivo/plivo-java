package com.plivo.api.models.application;

import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class ApplicationUpdater extends VoiceUpdater<ApplicationUpdateResponse> {

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
  private Boolean logIncomingMessages;
  private Boolean publicUri;

  public ApplicationUpdater(String id) {
    super(id);
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

  public Boolean logIncomingMessages() {
    return this.logIncomingMessages;
  }

  public Boolean publicUri() {
    return this.publicUri;
  }

  public ApplicationUpdater answerUrl(final String answerUrl) {
    this.answerUrl = answerUrl;
    return this;
  }

  public ApplicationUpdater answerMethod(final String answerMethod) {
    this.answerMethod = answerMethod;
    return this;
  }

  public ApplicationUpdater hangupUrl(final String hangupUrl) {
    this.hangupUrl = hangupUrl;
    return this;
  }

  public ApplicationUpdater hangupMethod(final String hangupMethod) {
    this.hangupMethod = hangupMethod;
    return this;
  }

  public ApplicationUpdater fallbackAnswerUrl(final String fallbackAnswerUrl) {
    this.fallbackAnswerUrl = fallbackAnswerUrl;
    return this;
  }

  public ApplicationUpdater fallbackMethod(final String fallbackMethod) {
    this.fallbackMethod = fallbackMethod;
    return this;
  }

  public ApplicationUpdater messageUrl(final String messageUrl) {
    this.messageUrl = messageUrl;
    return this;
  }

  public ApplicationUpdater messageMethod(final String messageMethod) {
    this.messageMethod = messageMethod;
    return this;
  }

  public ApplicationUpdater defaultNumberApp(final Boolean defaultNumberApp) {
    this.defaultNumberApp = defaultNumberApp;
    return this;
  }

  public ApplicationUpdater defaultEndpointApp(final Boolean defaultEndpointApp) {
    this.defaultEndpointApp = defaultEndpointApp;
    return this;
  }

  public ApplicationUpdater subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  public ApplicationUpdater logIncomingMessages(final Boolean logIncomingMessages) {
    this.logIncomingMessages = logIncomingMessages;
    return this;
  }

  public ApplicationUpdater publicUri(final Boolean publicUri) {
    this.publicUri = publicUri;
    return this;
  }


  @Override
  protected Call<ApplicationUpdateResponse> obtainCall(String identifier) {
    this.id = null;
    return client().getVoiceApiService().applicationUpdate(client().getAuthId(), identifier, this);
  }

  @Override
  protected Call<ApplicationUpdateResponse> obtainFallback1Call(String identifier) {
    this.id = null;
    return client().getVoiceFallback1Service().applicationUpdate(client().getAuthId(), identifier, this);
  }

  @Override
  protected Call<ApplicationUpdateResponse> obtainFallback2Call(String identifier) {
    this.id = null;
    return client().getVoiceFallback2Service().applicationUpdate(client().getAuthId(), identifier, this);
  }
}