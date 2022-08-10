package com.plivo.api.models.token;

import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;
import org.json.simple.* ;


public class TokenCreator extends VoiceCreator<TokenCreateResponse> {

  private final String iss;
  private String sub;
  private Integer nbf;
  private Integer exp;
  private String app;
  private Boolean incoming_allow;
  private Boolean outgoing_allow;
  private JSONObject per;




  public TokenCreator(String iss) {
    this.iss = iss;
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
    return this.incoming_allow;
  }
  public TokenCreator incoming_allow(final boolean incoming_allow) {
    this.incoming_allow = incoming_allow;
    return this;
  }
  public boolean outgoing_allow() {
    return this.outgoing_allow;
  }
  public TokenCreator outgoing_allow(final boolean outgoing_allow) {
    this.outgoing_allow = outgoing_allow;
    return this;
  }
  public JSONObject per() {
    return this.per;
  }
  public TokenCreator per(final JSONObject per) {
    JSONObject permission = new JSONObject();
    JSONObject voice = new JSONObject();
    voice.put("outgoing_allow", outgoing_allow);
    permission.put("voice", voice);
    this.per = permission;
    return this;
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