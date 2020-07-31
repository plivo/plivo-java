package com.plivo.api.models.media;

import com.plivo.api.models.base.BaseResponse;

public class MediaResponse  extends BaseResponse {
  private List<MediaUploadResponse> objects;


  public List<MediaUploadResponse> getObjects() {
    return objects;
  }
}

