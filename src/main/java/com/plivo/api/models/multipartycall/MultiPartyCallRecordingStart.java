package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.Updater;
import com.plivo.api.validators.OneOf;
import com.plivo.api.validators.UrlValues;
import com.plivo.api.validators.Validate;
import retrofit2.Call;

public class MultiPartyCallRecordingStart extends Updater<MultiPartyCallRecordingStartResponse> {

  @OneOf(message = "should be one of [mp3, wav]", options = {"mp3", "wav"})
  private String fileFormat = "mp3";
  @UrlValues
  private String statusCallbackUrl;
  @OneOf(message = "should be one of [GET, POST]", options = {"GET", "POST"})
  private String StatusCallbackMethod = "POST";

  public MultiPartyCallRecordingStart(String mpcId) {
    super(mpcId);
  }

  public String getFileFormat() {
    return fileFormat;
  }

  public String getStatusCallbackUrl() {
    return statusCallbackUrl;
  }

  public String getStatusCallbackMethod() {
    return StatusCallbackMethod;
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
    StatusCallbackMethod = statusCallbackMethod;
    return this;
  }

  @Override
  protected Call<MultiPartyCallRecordingStartResponse> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getApiService().mpcStartRecording(client().getAuthId(), id, this);
  }
}
