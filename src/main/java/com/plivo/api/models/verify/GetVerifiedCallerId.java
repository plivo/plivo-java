package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class GetVerifiedCallerId extends VoiceGetter<GetVerifiedCallerIdResponse> {
  public GetVerifiedCallerId(String id) {
    super(id);
  }

  @Override
  protected Call<GetVerifiedCallerIdResponse> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().getVerifiedCallerID(client().getAuthId(), id);
  }

  @Override
  protected Call<GetVerifiedCallerIdResponse> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().getVerifiedCallerID(client().getAuthId(), id);
  }

  @Override
  protected Call<GetVerifiedCallerIdResponse> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().getVerifiedCallerID(client().getAuthId(), id);
  }
}
