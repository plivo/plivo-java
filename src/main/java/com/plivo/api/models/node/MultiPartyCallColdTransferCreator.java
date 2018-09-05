package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;

import java.io.IOException;

public class MultiPartyCallColdTransferCreator
    extends MultiPartyCallCreatorAction<NodeActionResponse> {

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  /**
   * @param phloId        phlo id of the phlo object.
   * @param nodeType      node type.
   * @param nodeId        id of the node.
   * @param triggerSource the trigger source number.
   * @param to            the to number.
   * @param role          the role.
   */
  public MultiPartyCallColdTransferCreator(final String phloId, final NodeType nodeType,
      final String nodeId, final String triggerSource, final String to, final String role) {
    super(phloId, nodeType, nodeId, triggerSource, to, role,
      MultiPartyCallActionType.COLD_TRANSFER);
  }

  public NodeActionResponse coldtransfer() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  @Override
  public MultiPartyCallColdTransferCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  @Override
  protected Call<NodeActionResponse> obtainCall() {
    return client().getApiService()
      .nodeAction(phloId, this.nodeType, this.nodeId, this.multiPartyCallActionPayload);
  }
}
