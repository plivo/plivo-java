package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import com.plivo.api.validators.OneOf;
import com.plivo.api.validators.UrlValues;
import com.plivo.api.validators.Validate;
import retrofit2.Call;

public class MultiPartyCallRecordingStart extends VoiceUpdater<MultiPartyCallRecordingStartResponse> {

  @OneOf(message = "should be one of [mp3, wav]", options = {"mp3", "wav"})
  private String fileFormat = "mp3";
  @UrlValues
  private String statusCallbackUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String statusCallbackMethod = "POST";

  public MultiPartyCallRecordingStart(String mpcId) {
    super(mpcId);
  }

  public String fileFormat() {
    return fileFormat;
  }

  public String statusCallbackUrl() {
    return statusCallbackUrl;
  }

  public String statusCallbackMethod() {
    return statusCallbackMethod;
  }

  public MultiPartyCallRecordingStart fileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  public MultiPartyCallRecordingStart statusCallbackUrl(String statusCallbackUrl) {
    this.statusCallbackUrl = statusCallbackUrl;
    return this;
  }

  public MultiPartyCallRecordingStart statusCallbackMethod(String statusCallbackMethod) {
    this.statusCallbackMethod = statusCallbackMethod;
    return this;
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceApiService().mpcStartRecording(client().getAuthId(), id, this);
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback1Service().mpcStartRecording(client().getAuthId(), id, this);
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback2Service().mpcStartRecording(client().getAuthId(), id, this);
  }
}