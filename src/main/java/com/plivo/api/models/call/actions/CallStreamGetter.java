package com.plivo.api.models.call.actions;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import com.plivo.api.models.recording.Recording;
import retrofit2.Call;

public class CallStreamGetter extends VoiceGetter<CallStreamGet>  {

  public CallStreamGetter(String id) {
    super(id);
  }

  @Override
  protected Call<CallStreamGet> obtainCall() throws PlivoValidationException {
    return null;
  }

  @Override
  protected Call<CallStreamGet> obtainFallback1Call() throws PlivoValidationException {
    return null;
  }

  @Override
  protected Call<CallStreamGet> obtainFallback2Call() throws PlivoValidationException {
    return null;
  }
}
