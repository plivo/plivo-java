package com.plivo.api.models.conference;

import com.plivo.api.models.base.BaseResponse;

public class ConferenceRecordCreateResponse extends BaseResponse {

  private String recordingId;
  private String url;

  public String getRecordingId() {
    return recordingId;
  }

  public String getUrl() {
    return url;
  }
}
