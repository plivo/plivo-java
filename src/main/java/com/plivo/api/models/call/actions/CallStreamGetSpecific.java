package com.plivo.api.models.call.actions;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

import java.io.IOException;

public class CallStreamGetSpecific extends VoiceGetter<CallStreamGet> {

  private String streamId;

  public CallStreamGetSpecific(String id, String streamId) {
    super(id, streamId);
  }

  @Override
  protected Call<CallStreamGet> obtainCall() {
    return client().getVoiceApiService().callStreamGetSpecific(client().getAuthId(), id, streamId);
  }

  @Override
  protected Call<CallStreamGet> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamGetSpecific(client().getAuthId(), id, streamId);
  }

  @Override
  protected Call<CallStreamGet> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamGetSpecific(client().getAuthId(), id, streamId);
  }

}