package com.plivo.api.models.verify;

import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

public class InitiateVerify extends VoiceCreator<InitiateVerifyResponse> {

  private String phoneNumber;
  private String alias;
  private String channel;
  private String subaccount;

  public String getPhoneNumber() {
    return phoneNumber;
  }
  public String getAlias() {
    return alias;
  }
  public String getChannel() {
    return channel;
  }
  public String getSubaccount() {
    return subaccount;
  }

  public InitiateVerify phoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }
  public InitiateVerify alias(final String alias) {
    this.alias = alias;
    return this;
  }
  public InitiateVerify channel(final String channel) {
    this.channel = channel;
    return this;
  }
  public InitiateVerify subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  @Override
  protected Call<InitiateVerifyResponse> obtainCall() {
    return client().getVoiceApiService().initiateVerify(client().getAuthId(),this);
  }

  @Override
  protected Call<InitiateVerifyResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().initiateVerify(client().getAuthId(), this);
  }

  @Override
  protected Call<InitiateVerifyResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().initiateVerify(client().getAuthId(), this);
  }

}
