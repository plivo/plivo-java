package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class ListVerifiedCallerId extends VoiceGetter<ListVerifiedCallerIdResponse> {


  public ListVerifiedCallerId() {
    super("");
  }

  @Override
  protected Call<ListVerifiedCallerIdResponse> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().listVerifiedCallerID(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListVerifiedCallerIdResponse> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().listVerifiedCallerID(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListVerifiedCallerIdResponse> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().listVerifiedCallerID(client().getAuthId(), toMap());
  }
}
