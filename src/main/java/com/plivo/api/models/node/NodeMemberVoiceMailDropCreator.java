package com.plivo.api.models.node;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class NodeMemberVoiceMailDropCreator extends NoderMemberCreatorAction<NodeActionResponse> {

  /**
   * @param phloId phlo id of the phlo.
   * @param nodeType node type.
   * @param nodeId id of the node.
   * @param memberId id of the member.
   */
  public NodeMemberVoiceMailDropCreator(final String phloId, final NodeType nodeType,
                                        final String nodeId, final String memberId) {
    super(phloId, nodeType, nodeId, memberId, NodeMemberActionType.VOICEMAIL_DROP);

  }

  public NodeActionResponse voicemaildrop() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public NodeMemberVoiceMailDropCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getPhloRestClient().getApiService()
      .memberAction(this.phloId, this.nodeType, this.nodeId, this.memberId, this.payload);
  }
}
