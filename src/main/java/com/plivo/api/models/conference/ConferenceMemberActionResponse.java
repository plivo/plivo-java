package com.plivo.api.models.conference;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class ConferenceMemberActionResponse extends BaseResponse {

  private List<String> memberId;

  public List<String> getMemberId() {
    return memberId;
  }
}
