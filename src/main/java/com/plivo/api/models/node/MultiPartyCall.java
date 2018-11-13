package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiPartyCall extends Node {

  private String phloId;
  private String nodeId;
  private String nodeType;
  private String name;
  private String createdOn;

  public static MultiPartyCallUpdater updater(String phloId, String id) {
    return new MultiPartyCallUpdater(phloId, id);
  }

  public static MultiPartyCallGetter getter(String phloId, String id) {
    return new MultiPartyCallGetter(phloId, id);
  }

  public MultiPartyCallUpdater updater() {
    return MultiPartyCall.updater(this.phloId, this.nodeId);
  }

  @Override
  public String getPhloId() {
    return phloId;
  }

  public void setPhloId(String phloId) {
    this.phloId = phloId;
  }

  @Override
  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  @Override
  public String getNodeType() {
    return nodeType;
  }

  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }
}
