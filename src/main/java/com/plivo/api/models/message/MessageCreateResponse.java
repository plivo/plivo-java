package com.plivo.api.models.message;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class MessageCreateResponse extends BaseResponse {

  List<String> messageUuid;

  public List<String> getMessageUuid() {
    return messageUuid;
  }
}
