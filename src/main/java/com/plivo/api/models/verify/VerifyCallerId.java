package com.plivo.api.models.verify;

import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

public class VerifyCallerId extends VoiceCreator<VerifyCallerIdResponse> {

  private String otp;

  private final String id;

  public VerifyCallerId(String id) {
    if (id == null) {
      throw new IllegalArgumentException("verification uuid cannot be null");
    }
    this.id = id;
  }

  @Override
  protected Call<VerifyCallerIdResponse> obtainCall() {
    return client().getVoiceApiService().verifyCallerID(client().getAuthId(),id,this);
  }

  @Override
  protected Call<VerifyCallerIdResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().verifyCallerID(client().getAuthId(),id,this);
  }

  @Override
  protected Call<VerifyCallerIdResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().verifyCallerID(client().getAuthId(),id,this);
  }
}
