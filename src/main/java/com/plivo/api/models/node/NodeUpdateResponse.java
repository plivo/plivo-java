package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;

public class NodeUpdateResponse extends BaseResponse {
  private String error;

  public String getError()
  {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }
}
