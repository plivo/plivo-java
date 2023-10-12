package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class UpdateVerifiedCallerID extends VoiceUpdater<UpdateVerifiedCallerIdResponse> {

  private String alias;
  private String subaccount;

  public UpdateVerifiedCallerID(String id) {
    super(id);
  }

  @Override
  protected Call obtainCall() throws PlivoValidationException {
    return client().getVoiceApiService().updateVerifiedCallerID(client().getAuthId(), id, this);
  }

  @Override
  protected Call obtainFallback1Call() throws PlivoValidationException {
    return client().getVoiceFallback1Service().updateVerifiedCallerID(client().getAuthId(), id, this);
  }

  @Override
  protected Call obtainFallback2Call() throws PlivoValidationException {
    return client().getVoiceFallback2Service().updateVerifiedCallerID(client().getAuthId(), id, this);
  }
}
