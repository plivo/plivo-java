package com.plivo.api.models.verify;

import com.plivo.api.models.base.BaseResponse;

public class VerifyMeta extends BaseResponse {

  private int limit;
  private String next;
  private String offset;
  private String previous;
  private int totalCount;

  public int getLimit() {
    return limit;
  }

  public String getNext() {
    return next;
  }

  public String getOffset() {
    return offset;
  }

  public String getPrevious() {
    return previous;
  }

  public int getTotalCount() {
    return totalCount;
  }
}
