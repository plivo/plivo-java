package com.plivo.api.models.call;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CallCreateResponse extends BaseResponse {

  private Object requestUuid;

  private List<String> invalidNumbers;

  public Object getRequestUuid() {
    return requestUuid;
  }

  public List<String> getInvalidNumbers() {
    return invalidNumbers;
  }
}
