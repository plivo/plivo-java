package com.plivo.api.models.node;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class NodeColdTransferCreator extends NodeCreatorAction<NodeActionResponse> {
  /**
   * @param phloId         phlo id of the phlo object.
   * @param nodeType       node type.
   * @param nodeId         id of the node.
   * @param triggerSource  the trigger source number.
   * @param to             the to number.
   * @param role           the role.
   */
  public NodeColdTransferCreator(final String phloId, final NodeType nodeType, final String nodeId,
                                 final String triggerSource, final String to, final String role) {
    super(phloId, nodeType, nodeId, triggerSource, to, role, NodeActionType.COLD_TRANSFER);
  }

  public NodeActionResponse coldtransfer() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public NodeColdTransferCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getPhloRestClient().getApiService()
      .nodeAction(phloId, this.nodeType, this.nodeId, this.nodeActionPayload);
  }
}
