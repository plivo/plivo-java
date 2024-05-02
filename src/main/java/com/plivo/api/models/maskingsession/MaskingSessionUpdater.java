package com.plivo.api.models.maskingsession;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class MaskingSessionUpdater extends VoiceUpdater<MaskingSessionUpdateResponse> {

  public MaskingSessionUpdater(String sessionUuid) {
    super(sessionUuid);
  }

  @Override
  protected Call<MaskingSessionUpdateResponse> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().maskingSessionUpdate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<MaskingSessionUpdateResponse> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().maskingSessionUpdate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<MaskingSessionUpdateResponse> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().maskingSessionUpdate(client().getAuthId(), id, this);
  }
}

