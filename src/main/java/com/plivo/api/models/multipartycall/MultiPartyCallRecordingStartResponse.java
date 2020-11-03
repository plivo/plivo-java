package com.plivo.api.models.multipartycall;

import com.plivo.api.models.base.BaseResponse;

public class MultiPartyCallRecordingStartResponse extends BaseResponse {

  private String recordingId;
  private String recordingUrl;

  public String getRecordingId() {
    return recordingId;
  }

  public MultiPartyCallRecordingStartResponse setRecordingId(String recordingId) {
    this.recordingId = recordingId;
    return this;
  }

  public String getRecordingUrl() {
    return recordingUrl;
  }

  public MultiPartyCallRecordingStartResponse setRecordingUrl(String recordingUrl) {
    this.recordingUrl = recordingUrl;
    return this;
  }

}