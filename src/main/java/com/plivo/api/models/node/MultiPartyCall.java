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

}
