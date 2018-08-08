package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public class TriggerApiNodeAction<T extends BaseResponse> extends Creator<ActionResponse> {

  private final String phloId;
  private final String nodeId;
  private final NodeType nodeType;
  private NodeActionPayload nodeActionPayload;

  public TriggerApiNodeAction(final String phloId, final NodeType nodeType, final String nodeId, final String triggerSource,
                              final String to, final String role, final NodeActionType nodeActionType) {
    this.nodeType = nodeType;
    this.phloId = phloId;
    this.nodeId = nodeId;
    this.nodeActionPayload = new NodeActionPayload(triggerSource, to, role, nodeActionType);
  }

  @Override
  protected Call<ActionResponse> obtainCall() {
    return client().getPhloRestClient().getApiService().nodeAction(this.phloId, this.nodeType,
      this.nodeId, this.nodeActionPayload);
  }
}
