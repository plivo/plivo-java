package com.plivo.api.models.profile;

import com.plivo.api.models.base.BaseResponse;

public class ProfileAddResponse extends BaseResponse {
  private String profileUUID;

  public String getProfileUUID(){
      return profileUUID;
  }
}