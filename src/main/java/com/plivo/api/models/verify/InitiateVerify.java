package com.plivo.api.models.verify;

import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

public class InitiateVerify extends VoiceCreator<InitiateVerifyResponse> {

  private String phoneNumber;
  private String alias;
  private String channel;
  private String country;
  private String subaccount;
  private Integer accountId;
  private String authId;
  private String authToken;


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
