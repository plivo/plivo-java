package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;

public class VerifiedCallerIdDeleter extends VoiceDeleter<Verify> {

  public VerifiedCallerIdDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().deleteVerifiedCallerID(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().deleteVerifiedCallerID(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().deleteVerifiedCallerID(client().getAuthId(), id);
  }

}
