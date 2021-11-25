package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import com.plivo.api.validators.UrlValues;
import com.plivo.api.validators.Validate;
import retrofit2.Call;

public class MultiPartyCallStartPlayAudio extends VoiceUpdater<MultiPartyCallStartPlayAudioResponse> {

  @UrlValues
  private String url;

  public MultiPartyCallStartPlayAudio(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  @Override
  protected Call<MultiPartyCallStartPlayAudioResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceApiService().mpcStartPlayAudio(client().getAuthId(), id, secondaryId, this);
  }

  @Override
  protected Call<MultiPartyCallStartPlayAudioResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback1Service().mpcStartPlayAudio(client().getAuthId(), id, secondaryId, this);
  }

  @Override
  protected Call<MultiPartyCallStartPlayAudioResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback1Service().mpcStartPlayAudio(client().getAuthId(), id, secondaryId, this);
  }

  public String url() {
    return url;
  }

  public MultiPartyCallStartPlayAudio url(String url) {
    this.url = url;
    return this;
  }
}