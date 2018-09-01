package com.plivo.api.models.node;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class NodeWarmTransferCreator extends NodeCreatorAction<NodeActionResponse> {
  /**
   * @param phloId         phlo id of the phlo object.
   * @param nodeType       node type.
   * @param nodeId         id of the node.
   * @param triggerSource  the trigger source number.
   * @param to             the to number.
   * @param role           the role.
   */
  public NodeWarmTransferCreator(final String phloId, final NodeType nodeType, final String nodeId,
                                 final String triggerSource, final String to, final String role) {
    super(phloId, nodeType, nodeId, triggerSource, to, role, NodeActionType.WARM_TRANSFER);
  }

  public NodeActionResponse warmtransfer() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public NodeWarmTransferCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getPhloRestClient().getApiService()
      .nodeAction(phloId, this.nodeType, this.nodeId, this.nodeActionPayload);
  }
}
