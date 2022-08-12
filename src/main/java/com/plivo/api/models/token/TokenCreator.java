package com.plivo.api.models.token;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

import java.io.IOException;


public class TokenCreator extends VoiceCreator<TokenCreateResponse> {

  private final String iss;

  private String sub;

  private Integer nbf;

  private Integer exp;

  private String app;

  private TokenPermission per;

  public TokenCreator(String iss) {
    this.iss = iss;
    this.per = new TokenPermission();
  }

  public String sub() {
    return this.sub;
  }

  public TokenCreator sub(final String sub) {
    this.sub = sub;
    return this;
  }

  public Integer nbf() {
    return this.nbf;
  }

  public TokenCreator nbf(final Integer nbf) {
    this.nbf = nbf;
    return this;
  }

  public Integer exp() {
    return this.exp;
  }

  public TokenCreator exp(final Integer exp) {
    this.exp = exp;
    return this;
  }

  public String app() {
    return this.app;
  }

  public TokenCreator app(final String app) {
    this.app = app;
    return this;
  }

  public boolean incoming_allow() {
    return this.per.voice.incomingAllow;
  }
  public TokenCreator incoming_allow(final boolean incoming_allow) {
    this.per.voice.incomingAllow = incoming_allow;
    return this;
  }

  public boolean outgoing_allow() {
    return this.per.voice.outgoingAllow;
  }

  public TokenCreator outgoing_allow(final boolean outgoing_allow) {
    this.per.voice.outgoingAllow = outgoing_allow;
    return this;
  }

  public TokenPermission per() {
    return this.per;
  }

  public TokenCreateResponse createToken() throws PlivoRestException, IOException {
    validateParams();
    return create();
  }

  private void validateParams() {
    if (sub == null && incoming_allow() == true) {
      throw new IllegalArgumentException("sub should be present if incoming is allowed");
    }

    if (nbf() != null && exp() != null) {
      if (nbf > exp) {
        throw new IllegalArgumentException("exp should be greater than nbf");
      }
    }

  }

  @Override
  protected Call<TokenCreateResponse> obtainCall() {
    return client().getVoiceApiService().tokenCreate(client().getAuthId(),this);
  }
  @Override
  protected Call<TokenCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().tokenCreate(client().getAuthId(),this);
  }
  @Override
  protected Call<TokenCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().tokenCreate(client().getAuthId(),this);
  }


}