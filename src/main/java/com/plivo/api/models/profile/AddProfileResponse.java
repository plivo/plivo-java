package com.plivo.api.models.profile;

import com.plivo.api.models.base.BaseResponse;

public class AddProfileResponse extends BaseResponse {

  public ProfileAddResponse profile;

  public ProfileAddResponse profile() {
    return profile;
  }
}