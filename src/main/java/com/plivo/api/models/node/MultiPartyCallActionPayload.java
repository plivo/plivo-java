package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiPartyCallActionPayload {

  private String triggerSource;
  private String to;
  private String role;
  private MultiPartyCallActionType action;

  /**
   * @param triggerSource the number triggering the action.
   * @param to            to number.
   * @param role          role of the node.
   * @param action        one of the node action types.
   */
  public MultiPartyCallActionPayload(final String triggerSource, final String to,
                                     final String role, final MultiPartyCallActionType action) {
    this.triggerSource = triggerSource;
    this.to = to;
    this.role = role;
    this.action = action;
  }

  public String getTriggerSource() {
    return triggerSource;
  }

  public String getTo() {
    return to;
  }

  public String getRole() {
    return role;
  }

  public MultiPartyCallActionType getAction() {
    return action;
  }
}
