package com.plivo.api.models.node;

public class MultiPartyCall extends Node {

  public NodeCallCreator callCreator(final String triggerSource, final String to, final String role){
    return new NodeCallCreator(this.phloId, this.nodeType, this.nodeId, triggerSource, to, role);
  }

  public NodeColdTransferCreator coldTransferCreator(final String triggerSource, final String to, final String role){
    return new NodeColdTransferCreator(this.phloId, this.nodeType, this.nodeId, triggerSource, to, role);
  }

  public NodeWarmTransferCreator warmTransferCreator(final String triggerSource, final String to, final String role){
    return new NodeWarmTransferCreator(this.phloId, this.nodeType, this.nodeId, triggerSource, to, role);
  }

  public MultiPartyCallMemberHangUpCreator memberHangUpCreator(final String memberId){
    return new MultiPartyCallMemberHangUpCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public MultiPartyCallMemberHoldCreator memberHoldCreator(final String memberId){
    return new MultiPartyCallMemberHoldCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public MultiPartyCallMemberUnHoldCreator memberUnHoldCreator(final String memberId){
    return new MultiPartyCallMemberUnHoldCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public MultiPartyCallMemberResumeCallCreator memberResumeCallCreator(final String memberId){
    return new MultiPartyCallMemberResumeCallCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public MultiPartyCallMemberVoiceMailDropCreator memberVoiceMailDropCreator(final String memberId){
    return new MultiPartyCallMemberVoiceMailDropCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }

  public MultiPartyCallMemberAbortWarmTransferCreator memberAbortWarmTransferCreator(final String memberId) {
    return new MultiPartyCallMemberAbortWarmTransferCreator(this.phloId, this.nodeType, this.nodeId, memberId);
  }
}
