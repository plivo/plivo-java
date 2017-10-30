package com.plivo.api.models.call.actions;

import com.plivo.api.models.base.BaseResponse;

public class CallRecordCreateResponse extends BaseResponse {

  private String url;
  private String recordingId;

  public String getUrl() {
    return url;
  }

  public String getRecordingId() {
    return recordingId;
  }
}
