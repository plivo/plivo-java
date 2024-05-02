package com.plivo.api.models.maskingsession;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class MaskingSessionGetter extends VoiceGetter<MaskingSession> {
  public MaskingSessionGetter(String id) {
    super(id);
  }

  @Override
  protected Call<MaskingSession> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().maskingSessionGet(client().getAuthId(), id);
  }

  @Override
  protected Call<MaskingSession> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().maskingSessionGet(client().getAuthId(), id);
  }

  @Override
  protected Call<MaskingSession> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().maskingSessionGet(client().getAuthId(), id);
  }
}
