package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResource;

public class MultiPartyCallMember extends BaseResource {

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
  public MultiPartyCallMember(final String phloId, final NodeType nodeType,
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

  public TriggerApiMemberAction update(final MemberActionType actionType) {
    return new TriggerApiMemberAction(this.phloId, this.nodeType, this.nodeId,
        this.memberId, actionType);
  }

  public TriggerApiMemberAction hold() {
    return update(MemberActionType.HOLD);
  }

  public TriggerApiMemberAction unhold() {
    return update(MemberActionType.UNHOLD);
  }

  public TriggerApiMemberAction hangup() {
    return update(MemberActionType.HANGUP);
  }

  public TriggerApiMemberAction resumeCall() {
    return update(MemberActionType.RESUMECALL);
  }

  public TriggerApiMemberAction abortWarmTransfer() {
    return update(MemberActionType.ABORTWARMTRANSFER);
  }

  public TriggerApiMemberAction voiceMailDrop() {
    return update(MemberActionType.VOICEMAILDROP);
  }

  @Override
  public String getId() {
    return getMemberId();
  }
}
