package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class MultiPartyCallWarmTransferCreator
      extends MultiPartyCallCreatorAction<NodeActionResponse> {

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  /**
   * @param phloId         phlo id of the phlo object.
   * @param nodeType       node type.
   * @param nodeId         id of the node.
   * @param triggerSource  the trigger source number.
   * @param to             the to number.
   * @param role           the role.
   */
  public MultiPartyCallWarmTransferCreator(final String phloId, final NodeType nodeType,
      final String nodeId, final String triggerSource, final String to, final String role) {
    super(phloId, nodeType, nodeId, triggerSource, to, role,
      MultiPartyCallActionType.WARM_TRANSFER);
  }

  public NodeActionResponse warmtransfer() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public MultiPartyCallWarmTransferCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getApiService()
      .nodeAction(phloId, this.nodeType, this.nodeId, this.multiPartyCallActionPayload);
  }
}
