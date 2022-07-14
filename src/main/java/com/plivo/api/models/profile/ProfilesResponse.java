package com.plivo.api.models.profile;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class ProfilesResponse extends BaseResponse {

  List<ProfileResponse> profiles;

  public List<ProfileResponse> getProfiless() {
    return profiles;
  }
}