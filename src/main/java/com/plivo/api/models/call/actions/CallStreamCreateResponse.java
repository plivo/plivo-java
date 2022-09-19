package com.plivo.api.models.call.actions;

import com.plivo.api.models.base.BaseResponse;

public class CallStreamCreateResponse extends BaseResponse {

  private String url;
  private String streamId;

  public String getUrl() {
    return url;
  }

  public String getStreamId() {
    return streamId;
  }
}
