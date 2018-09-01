package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public abstract class NoderMemberCreatorAction<T extends BaseResponse> extends Creator<T> {

  protected final String phloId;
  protected final String nodeId;
  protected final String memberId;
  protected final NodeType nodeType;
  protected NodeMemberActionPayload payload;

  /**
   * @param phloId phlo id of the phlo.
   * @param nodeType node type.
   * @param nodeId id of the node.
   * @param memberId id of the member.
   * @param actionType action type, can be one of the action types.
   */
  public NoderMemberCreatorAction(final String phloId, final NodeType nodeType,
                                  final String nodeId, final String memberId,
                                  final NodeMemberActionType actionType) {
    this.phloId = phloId;
    this.nodeType = nodeType;
    this.nodeId = nodeId;
    this.memberId = memberId;
    this.payload = new NodeMemberActionPayload(actionType);
  }
}
