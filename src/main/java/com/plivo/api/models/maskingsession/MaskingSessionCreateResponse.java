package com.plivo.api.models.maskingsession;

import com.plivo.api.models.base.BaseResponse;

public class MaskingSessionCreateResponse extends BaseResponse {
  private String sessionUuid;
  private String virtualNumber;
  private Object session;

  public String getSessionUuid() {
    return sessionUuid;
  }
  public String getVirtualNumber() {
    return virtualNumber;
  }
  public Object getSession() {
    return session;
  }
}
