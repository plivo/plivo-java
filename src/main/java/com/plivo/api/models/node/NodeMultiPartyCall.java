package com.plivo.api.models.node;

public class NodeMultiPartyCall extends Node {

  public NodeCallCreator callCreator(final String triggerSource, final String to, final String role){
    return new NodeCallCreator(this.phloId, this.nodeType, this.nodeId, triggerSource, to, role);
  }

  public NodeColdTransferCreator coldTransferCreator(final String triggerSource, final String to, final String role){
    return new NodeColdTransferCreator(this.phloId, this.nodeType, this.nodeId, triggerSource, to, role);
  }

  public NodeWarmTransferCreator warmTransferCreator(final String triggerSource, final String to, final String role){
    return new NodeWarmTransferCreator(this.phloId, this.nodeType, this.nodeId, triggerSource, to, role);
  }

  public NodeMemberHangUpCreator memberHangUpCreator(final String memberId){
    return new NodeMemberHangUpCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public NodeMemberHoldCreator  memberHoldCreator(final String memberId){
    return new NodeMemberHoldCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public NodeMemberUnHoldCreator memberUnHoldCreator(final String memberId){
    return new NodeMemberUnHoldCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public NodeMemberResumeCallCreator memberResumeCallCreator(final String memberId){
    return new NodeMemberResumeCallCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public NodeMemberVoiceMailDropCreator memberVoiceMailDropCreator(final String memberId){
    return new NodeMemberVoiceMailDropCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public NoderMemberAbortWarmTransferCreator memberAbortWarmTransferCreator(final String memberId) {
    return new NoderMemberAbortWarmTransferCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }
}
