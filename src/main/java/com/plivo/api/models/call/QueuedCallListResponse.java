package com.plivo.api.models.call;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class QueuedCallListResponse extends BaseResource {

  private List<String> calls;

  public List<String> getCalls() {
    return calls;
  }

  @Override
  public String getId() {
    return getApiId();
  }
}
