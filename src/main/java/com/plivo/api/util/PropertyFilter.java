package com.plivo.api.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.plivo.api.serializers.PropertyFilterSerializer;

@JsonSerialize(using = PropertyFilterSerializer.class)
public class PropertyFilter<T> {

  private T equalTo = null;
  private T greaterThan = null;
  private T greaterOrEqual = null;
  private T lessThan = null;
  private T lessOrEqual = null;

  public T equalTo() {
    return this.equalTo;
  }

  public T greaterThan() {
    return this.greaterThan;
  }

  public T greaterOrEqual() {
    return this.greaterOrEqual;
  }

  public T lessThan() {
    return this.lessThan;
  }

  public T lessOrEqual() {
    return this.lessOrEqual;
  }

  public PropertyFilter<T> equalTo(final T equalTo) {
    this.equalTo = equalTo;
    return this;
  }

  public PropertyFilter<T> greaterThan(final T greaterThan) {
    this.greaterThan = greaterThan;
    return this;
  }

  public PropertyFilter<T> greaterOrEqual(final T greaterOrEqual) {
    this.greaterOrEqual = greaterOrEqual;
    return this;
  }

  public PropertyFilter<T> lessThan(final T lessThan) {
    this.lessThan = lessThan;
    return this;
  }

  public PropertyFilter<T> lessOrEqual(final T lessOrEqual) {
    this.lessOrEqual = lessOrEqual;
    return this;
  }
}
