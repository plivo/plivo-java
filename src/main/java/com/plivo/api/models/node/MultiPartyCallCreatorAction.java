package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Creator;

public abstract class MultiPartyCallCreatorAction<T extends BaseResponse> extends Creator<T> {

  protected final String phloId;
  protected final String nodeId;
  protected final NodeType nodeType;
  protected MultiPartyCallActionPayload multiPartyCallActionPayload;

  /**
   * @param phloId                   phlo id of the phlo object.
   * @param nodeType                 node type.
   * @param nodeId                   id of the node.
   * @param triggerSource            the trigger source number.
   * @param to                       the to number.
   * @param role                     the role.
   * @param multiPartyCallActionType one of the node action types.
   */
  public MultiPartyCallCreatorAction(final String phloId, final NodeType nodeType,
       final String nodeId, final String triggerSource, final String to, final String role,
       final MultiPartyCallActionType multiPartyCallActionType) {
    this.nodeType = nodeType;
    this.phloId = phloId;
    this.nodeId = nodeId;
    this.multiPartyCallActionPayload = new MultiPartyCallActionPayload(triggerSource,
      to, role, multiPartyCallActionType);
  }
}
