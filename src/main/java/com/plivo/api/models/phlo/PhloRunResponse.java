package com.plivo.api.models.phlo;

import com.plivo.api.models.base.BaseResponse;

public class PhloRunResponse extends BaseResponse {
  private String phloId;
  private String phloRunId;
  private String error;

  public String getPhloId() {
    return phloId;
  }

  public String getPhloRunId() {
    return phloRunId;
  }

  public String getError() {
    return error;
  }
}
