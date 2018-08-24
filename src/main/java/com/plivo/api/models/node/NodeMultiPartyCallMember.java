package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResource;

public class NodeMultiPartyCallMember extends BaseResource {

  private String nodeId;
  private String phloId;
  private NodeType nodeType;
  private String memberId;

  /**
   *
   * @param phloId phlo id of the current flow.
   * @param nodeType node type of the node.
   * @param nodeId node id of the node.
   * @param memberId member id of the member.
   */
  public NodeMultiPartyCallMember(final String phloId, final NodeType nodeType,
                                  final String nodeId, final String memberId) {
    this.nodeId = nodeId;
    this.phloId = phloId;
    this.nodeType = nodeType;
    this.memberId = memberId;
  }

  public String getMemberId() {
    return memberId;
  }

  public String getNodeId() {
    return nodeId;
  }

  public String getPhloId() {
    return phloId;
  }

  public NodeType getNodeType() {
    return nodeType;
  }

  public NodeTriggerApiMemberAction update(final NodeMemberActionType actionType) {
    return new NodeTriggerApiMemberAction(this.phloId, this.nodeType, this.nodeId,
        this.memberId, actionType);
  }

  public NodeTriggerApiMemberAction hold() {
    return update(NodeMemberActionType.HOLD);
  }

  public NodeTriggerApiMemberAction unhold() {
    return update(NodeMemberActionType.UNHOLD);
  }

  public NodeTriggerApiMemberAction hangup() {
    return update(NodeMemberActionType.HANGUP);
  }

  public NodeTriggerApiMemberAction resumeCall() {
    return update(NodeMemberActionType.RESUMECALL);
  }

  public NodeTriggerApiMemberAction abortWarmTransfer() {
    return update(NodeMemberActionType.ABORTWARMTRANSFER);
  }

  public NodeTriggerApiMemberAction voiceMailDrop() {
    return update(NodeMemberActionType.VOICEMAILDROP);
  }

  @Override
  public String getId() {
    return getMemberId();
  }
}
