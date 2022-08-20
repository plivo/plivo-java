package com.plivo.api.models.base;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.NoSuchMethodException;

public class MessagingMeta {

  @JsonIgnore
  protected Long limit;
  @JsonIgnore
  protected String next;
  @JsonIgnore
  protected Long offset;
  @JsonIgnore
  protected String previous;
  @JsonIgnore
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
