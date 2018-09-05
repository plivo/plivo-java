package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiPartyCallMemberActionPayload {

  private MultiPartyCallMemberActionType action;

  public MultiPartyCallMemberActionPayload(final MultiPartyCallMemberActionType action) {
    this.action = action;
  }

  public MultiPartyCallMemberActionType getAction() {
    return action;
  }
}

