package com.plivo.api.models.maskingsession;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import retrofit2.Call;

public class MaskingSessionLister extends VoiceLister<MaskingSession> {
  @Override
  protected Call<ListResponse<MaskingSession>> obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().maskingSessionList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<MaskingSession>> obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().maskingSessionList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<MaskingSession>> obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().maskingSessionList(client().getAuthId(), toMap());
  }
}
