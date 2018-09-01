package com.plivo.api.models.node;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class NodeMemberHoldCreator extends NoderMemberCreatorAction<NodeActionResponse> {

  /**
   * @param phloId phlo id of the phlo.
   * @param nodeType node type.
   * @param nodeId id of the node.
   * @param memberId id of the member.
   */
  public NodeMemberHoldCreator(final String phloId, final NodeType nodeType,
                               final String nodeId, final String memberId){
    super(phloId, nodeType, nodeId, memberId, NodeMemberActionType.HOLD);

  }

  public NodeActionResponse hold() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public NodeMemberHoldCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getPhloRestClient().getApiService()
      .memberAction(this.phloId, this.nodeType, this.nodeId, this.memberId, this.payload);
  }
}
