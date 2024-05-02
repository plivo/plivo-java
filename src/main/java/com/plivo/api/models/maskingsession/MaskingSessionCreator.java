package com.plivo.api.models.maskingsession;

import com.plivo.api.models.base.VoiceCreator;
import com.plivo.api.models.endpoint.EndpointCreateResponse;
import retrofit2.Call;

public class MaskingSessionCreator extends VoiceCreator<MaskingSessionCreateResponse> {

  private final String firstParty;
  private final String secondParty;

  public MaskingSessionCreator(String firstParty, String secondParty) {
    this.firstParty = firstParty;
    this.secondParty = secondParty;
  }

  @Override
  protected Call<MaskingSessionCreateResponse> obtainCall() {
    return null;
  }

  @Override
  protected Call<MaskingSessionCreateResponse> obtainFallback1Call() {
    return null;
  }

  @Override
  protected Call<MaskingSessionCreateResponse> obtainFallback2Call() {
    return null;
  }
}
