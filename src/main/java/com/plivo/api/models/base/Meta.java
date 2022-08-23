package com.plivo.api.models.base;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.lang.NoSuchMethodException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {

  protected Long limit;
  protected String next;
  protected Long offset;
  protected String previous;
  protected Long totalCount;

  public Long getLimit() {
    return limit;
  }

  public String getNext() {
    return next;
  }

  public Long getOffset() {
    return offset;
  }

  public String getPrevious() {
    return previous;
  }

  public Long getTotalCount() throws NoSuchMethodException {
    return totalCount;
  }
}
