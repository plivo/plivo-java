package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public class TriggerApiMemberAction<T extends BaseResponse> extends Creator<ActionResponse> {

  private final String phloId;
  private final String nodeId;
  private final String memberId;
  private final NodeType nodeType;
  private MemberActionPayload payload;

  public TriggerApiMemberAction(final String phloId, final NodeType nodeType, final String nodeId, final String memberId, final MemberActionType actionType) {
    this.phloId = phloId;
    this.nodeType = nodeType;
    this.nodeId = nodeId;
    this.memberId = memberId;
    this.payload = new MemberActionPayload(actionType);
  }

  @Override
  protected Call<ActionResponse> obtainCall() {
    return client().getPhloRestClient().getApiService().memberAction(this.phloId, this.nodeType, this.nodeId, this.memberId, this.payload);
  }
}
