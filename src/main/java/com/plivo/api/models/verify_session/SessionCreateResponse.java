package com.plivo.api.models.verify_session;

import com.plivo.api.models.base.BaseResponse;

import java.util.List;

public class SessionCreateResponse extends BaseResponse {
  String sessionUuid;

  public String getSessionUuid() {
    return sessionUuid;
  }
}
