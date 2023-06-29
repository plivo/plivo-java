package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceCreator;

import java.io.IOException;

public class CallStreamCreator extends VoiceCreator<CallStreamCreateResponse> {

  private final String id;
  private String serviceUrl;
  private Boolean bidirectional;
  private String audioTrack;
  private Integer streamTimeout;
  private String statusCallbackUrl;
  private String statusCallbackMethod;
  private String contentType;
  private String extraHeaders;

  public CallStreamCreator(String id, String serviceUrl) {
    this.id = id;
    this.serviceUrl = serviceUrl;
  }

  @Override
  protected retrofit2.Call<CallStreamCreateResponse> obtainCall() {
    return client().getVoiceApiService().callStreamCreate(client().getAuthId(), id, this);
  }

  @Override
  protected retrofit2.Call<CallStreamCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamCreate(client().getAuthId(), id, this);
  }

  @Override
  protected retrofit2.Call<CallStreamCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamCreate(client().getAuthId(), id, this);
  }

  public CallStreamCreateResponse stream() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public CallStreamCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  public CallStreamCreator serviceUrl(final String serviceUrl) {
    this.serviceUrl = serviceUrl;
    return this;
  }

  public CallStreamCreator bidirectional(final Boolean bidirectional) {
    this.bidirectional = bidirectional;
    return this;
  }
  public CallStreamCreator audioTrack(final String audioTrack) {
    this.audioTrack = audioTrack;
    return this;
  }
  public CallStreamCreator streamTimeout(final Integer streamTimeout) {
    this.streamTimeout = streamTimeout;
    return this;
  }
  public CallStreamCreator statusCallbackUrl(final String statusCallbackUrl) {
    this.statusCallbackUrl = statusCallbackUrl;
    return this;
  }
  public CallStreamCreator statusCallbackMethod(final String statusCallbackMethod) {
    this.statusCallbackMethod = statusCallbackMethod;
    return this;
  }

  public CallStreamCreator contentType(final String contentType) {
    this.contentType = contentType;
    return this;
  }

  public CallStreamCreator extraHeaders(final String extraHeaders) {
    this.extraHeaders = extraHeaders;
    return this;
  }

  public String serviceUrl() {
    return this.serviceUrl;
  }

  public Boolean bidirectional() {
    return this.bidirectional;
  }

  public String audioTrack() {
    return this.audioTrack;
  }

  public Integer streamTimeout() {
    return this.streamTimeout;
  }

  public String statusCallbackUrl() {
    return this.statusCallbackUrl;
  }

  public String statusCallbackMethod() {
    return this.statusCallbackMethod;
  }

  public String contentType() {
    return this.contentType;
  }

  public String extraHeaders() {
    return this.extraHeaders;
  }
}