package com.plivo.api.models.conference;

import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.Creator;

public abstract class ConferenceMemberCreatorAction<T extends BaseResponse> extends Creator<T> {

  protected final String conferenceName;
  protected final String memberId;

  public ConferenceMemberCreatorAction(String conferenceName, String memberId) {
    this.conferenceName = conferenceName;
    this.memberId = memberId;
  }
}
