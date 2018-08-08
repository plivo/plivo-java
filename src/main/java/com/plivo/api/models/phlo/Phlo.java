package com.plivo.api.models.phlo;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.node.NodeType;

public class Phlo extends BaseResource {

  private String phloId;
  private String phloName;

  @Override
  public String getId() {
    return getPhloId();
  }

  public String getPhloId() {
    return phloId;
  }

  public String getPhloName() {
    return phloName;
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

  public static PhloRunner runner(final String phloId) {
    return new PhloRunner(phloId);
  }

}
