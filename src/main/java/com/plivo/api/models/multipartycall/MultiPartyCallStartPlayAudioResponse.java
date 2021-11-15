package com.plivo.api.models.multipartycall;

import com.plivo.api.models.base.BaseResponse;

import java.util.List;

public class MultiPartyCallStartPlayAudioResponse extends BaseResponse {

    private List<String> mpcMemberId;
    private String mpcName;

    public List<String> getMpcMemberId() {
      return mpcMemberId;
    }
    public String mpcName() {
      return mpcName;
    }
}
