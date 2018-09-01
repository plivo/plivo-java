package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public abstract  class NodeCreatorAction<T extends BaseResponse> extends Creator<T> {

  protected final String phloId;
  protected final String nodeId;
  protected final NodeType nodeType;
  protected NodeActionPayload nodeActionPayload;

  /**
   * @param phloId         phlo id of the phlo object.
   * @param nodeType       node type.
   * @param nodeId         id of the node.
   * @param triggerSource  the trigger source number.
   * @param to             the to number.
   * @param role           the role.
   * @param nodeActionType one of the node action types.
   */
  public NodeCreatorAction(final String phloId, final NodeType nodeType, final String nodeId,
                           final String triggerSource, final String to, final String role,
                           final NodeActionType nodeActionType) {
    this.nodeType = nodeType;
    this.phloId = phloId;
    this.nodeId = nodeId;
    this.nodeActionPayload = new NodeActionPayload(triggerSource, to, role, nodeActionType);
  }
}
