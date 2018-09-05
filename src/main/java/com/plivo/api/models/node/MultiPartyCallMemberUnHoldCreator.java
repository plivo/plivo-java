package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class MultiPartyCallMemberUnHoldCreator
      extends MultiPartyCallMemberCreatorAction<NodeActionResponse> {

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  /**
   * @param phloId   phlo id of the phlo.
   * @param nodeType node type.
   * @param nodeId   id of the node.
   * @param memberId id of the member.
   */
  public MultiPartyCallMemberUnHoldCreator(final String phloId, final NodeType nodeType,
                                           final String nodeId, final String memberId) {
    super(phloId, nodeType, nodeId, memberId, MultiPartyCallMemberActionType.UNHOLD);

  }

  public NodeActionResponse unhold() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  @Override
  public MultiPartyCallMemberUnHoldCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getApiService()
      .memberAction(this.phloId, this.nodeType, this.nodeId, this.memberId, this.payload);
  }
}
