package com.plivo.api.models.verify;

import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

public class InitiateVerify extends VoiceCreator<InitiateVerifyResponse> {

  private String phoneNumber;
  private String alias;
  private String channel;
  private String country;
  private String subaccount;
  private int accountId;
  private String authId;
  private String authToken;

  public String getPhoneNumber() {
    return phoneNumber;
  }
  public String getAlias() {
    return alias;
  }
  public String getChannel() {
    return channel;
  }
  public String getCountry() {
    return country;
  }
  public String getSubaccount() {
    return subaccount;
  }
  public int getAccountId() {
    return accountId;
  }
  public String getAuthId() {
    return authId;
  }
  public String getAuthToken() {
    return authToken;
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
  public InitiateVerify country(final String country) {
    this.country = country;
    return this;
  }
  public InitiateVerify subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }
  public InitiateVerify accountId(final int accountId) {
    this.accountId = accountId;
    return this;
  }
  public InitiateVerify authId(final String authId) {
    this.authId = authId;
    return this;
  }
  public InitiateVerify authToken(final String authToken) {
    this.authToken = authToken;
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
