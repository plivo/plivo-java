package com.plivo.api.models.node;

public enum NodeType {

  MULTIPARTYCALL("multi_party_call");

  private final String type;

  NodeType(final String multipartycall) {
    this.type = multipartycall;
  }

  @Override
  public String toString() {
    return this.type;
  }
}
