package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node extends BaseResource {

  private String phloId;
  private String nodeId;
  private String nodeType;
  private String name;
  private String createdOn;


  public String getNodeId() {
    return nodeId;
  }

  public String getPhloId() {
    return phloId;
  }

  public String getNodeType() {
    return nodeType;
  }


  @Override
  public String getId() {
    return getNodeId();
  }
}
