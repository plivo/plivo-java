package com.plivo.api.models.maskingsession;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MaskingSessionDeleter extends VoiceDeleter<MaskingSession> {

  public MaskingSessionDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().maskingSessionDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().maskingSessionDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().maskingSessionDelete(client().getAuthId(), id);
  }
}

