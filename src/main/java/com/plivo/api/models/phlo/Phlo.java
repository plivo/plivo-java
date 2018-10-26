package com.plivo.api.models.phlo;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.node.NodeType;

import java.util.Map;

public class Phlo extends BaseResource {

  private String phloId;
  private String name;
  private String createdOn;

  @Override
  public String getId() {
    return getPhloId();
  }

  public String getPhloId() {
    return phloId;
  }

  public String getName() {
    return name;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public NodeGetter nodeGetter(final NodeType nodeType, final String nodeId) {
    return new NodeGetter(this.phloId, nodeType, nodeId);
  }

  public MultiPartyCallGetter multiPartyCallGetter(final String nodeId) {
    return new MultiPartyCallGetter(this.phloId, nodeId);
  }

  public static PhloGetter getter(final String phloId) {
    return new PhloGetter(phloId);
  }

  public PhloRunner runner() {
    return runner(this.phloId);
  }

  public static PhloRunner runner(final String phloId) {
    return new PhloRunner(phloId);
  }

  public static PhloRunner runner(final String phloId, final Map<String, String> payload) {
    return new PhloRunner(phloId, payload);
  }

}
