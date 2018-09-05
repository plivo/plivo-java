package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node extends BaseResource {

  protected String phloId;
  protected String nodeId;
  protected NodeType nodeType;
  private String name;
  private String createdOn;

  public Node(){}

  public String getPhloId() {
    return phloId;
  }

  public String getNodeId() {
    return nodeId;
  }

  public NodeType getNodeType() {
    return nodeType;
  }

  public String getName() {
    return name;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  @Override
  public String getId() {
    return getNodeId();
  }

}
