package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class MultiPartyCallUpdater extends Updater<MultiPartyCallUpdateResponse> {

  private String phloId;
  private String triggerSource;
  private String to;
  private String role;
  private MultiPartyCallActionType action;
  private NodeType nodeType;
  private MultiPartyCallUpdatePayload multiPartyCallUpdatePayload;
  private String member = null;


  public MultiPartyCallUpdater(String phloId, String id) {
    super(id);
    this.phloId = phloId;
    this.nodeType = NodeType.MULTI_PARTY_CALL;
  }

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  public String triggerSource() {
    return this.triggerSource;
  }

  public String to() {
    return this.to;
  }

  public String role() {
    return this.role;
  }

  public MultiPartyCallActionType action() {
    return this.action;
  }

  public String member() {
    return this.member;
  }

  public MultiPartyCallUpdater triggerSource(final String triggerSource) {
    this.triggerSource = triggerSource;
    return this;
  }

  public MultiPartyCallUpdater to(final String to) {
    this.to = to;
    return this;
  }

  public MultiPartyCallUpdater role(final String role) {
    this.role = role;
    return this;
  }

  public MultiPartyCallUpdater action(final MultiPartyCallActionType action) {
    this.action = action;
    return this;
  }

  public MultiPartyCallUpdater call() {
    this.action = MultiPartyCallActionType.CALL;
    return this;
  }

  public MultiPartyCallUpdater hold() {
    this.action = MultiPartyCallActionType.HOLD;
    return this;
  }

  public MultiPartyCallUpdater unhold() {
    this.action = MultiPartyCallActionType.UNHOLD;
    return this;
  }

  public MultiPartyCallUpdater cold_transfer() {
    this.action = MultiPartyCallActionType.COLD_TRANSFER;
    return this;
  }

  public MultiPartyCallUpdater warm_transfer() {
    this.action = MultiPartyCallActionType.WARM_TRANSFER;
    return this;
  }

  public MultiPartyCallUpdater hangup() {
    this.action = MultiPartyCallActionType.HANGUP;
    return this;
  }

  public MultiPartyCallUpdater resume_call() {
    this.action = MultiPartyCallActionType.RESUME_CALL;
    return this;
  }

  public MultiPartyCallUpdater abort_transfer() {
    this.action = MultiPartyCallActionType.ABORT_TRANSFER;
    return this;
  }

  public MultiPartyCallUpdater abort_warm_transfer() {
    this.action = MultiPartyCallActionType.ABORT_TRANSFER;
    return this;
  }

  public MultiPartyCallUpdater abort_cold_transfer() {
    this.action = MultiPartyCallActionType.ABORT_TRANSFER;
    return this;
  }

  public MultiPartyCallUpdater voicemail_drop() {
    this.action = MultiPartyCallActionType.VOICEMAIL_DROP;
    return this;
  }

  public MultiPartyCallUpdater member(final String member) {
    this.member = member;
    return this;
  }

  @Override
  protected Call<MultiPartyCallUpdateResponse> obtainCall() {
    this.multiPartyCallUpdatePayload = new MultiPartyCallUpdatePayload(this.triggerSource,
      this.to, this.role, this.action);
    if (this.member == null){
      return client().getApiService()
        .nodeAction(phloId, this.nodeType, this.id, this.multiPartyCallUpdatePayload);
    }
    else{
      return client().getApiService()
        .memberAction(phloId, this.nodeType, this.id, this.member, this.multiPartyCallUpdatePayload);
    }

  }
}
