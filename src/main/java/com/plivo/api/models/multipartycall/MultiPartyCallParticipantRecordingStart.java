package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import com.plivo.api.validators.OneOf;
import com.plivo.api.validators.UrlValues;
import com.plivo.api.validators.Validate;
import retrofit2.Call;

public class MultiPartyCallParticipantRecordingStart extends VoiceUpdater<MultiPartyCallRecordingStartResponse> {

  @OneOf(message = "should be one of [mp3, wav]", options = {"mp3", "wav"})
  private String fileFormat = "mp3";
  @UrlValues
  private String recordingCallbackUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String recordingCallbackMethod = "POST";

  public MultiPartyCallParticipantRecordingStart(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  public String fileFormat() {
    return fileFormat;
  }

  public String recordingCallbackUrl() {
    return recordingCallbackUrl;
  }

  public String recordingCallbackMethod() {
    return recordingCallbackMethod;
  }

  public MultiPartyCallParticipantRecordingStart fileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  public MultiPartyCallParticipantRecordingStart recordingCallbackUrl(String recordingCallbackUrl) {
    this.recordingCallbackUrl = recordingCallbackUrl;
    return this;
  }

  public MultiPartyCallParticipantRecordingStart recordingCallbackMethod(String recordingCallbackMethod) {
    this.recordingCallbackMethod = recordingCallbackMethod;
    return this;
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceApiService().mpcParticipantStartRecording(client().getAuthId(), id, secondaryId, this);
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback1Service().mpcParticipantStartRecording(client().getAuthId(), id, secondaryId, this);
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback2Service().mpcParticipantStartRecording(client().getAuthId(), id, secondaryId, this);
  }
}