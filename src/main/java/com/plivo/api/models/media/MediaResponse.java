package com.plivo.api.models.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.models.base.BaseResponse;

import java.util.List;

//@JsonIgnoreProperties(value = {"status_code","status"})
public class MediaResponse  extends BaseResponse {
  private List<MediaUploadResponse> objects;

  @JsonIgnoreProperties(value = {"status_code","status"})
  public List<MediaUploadResponse> getObjects() {
    return objects;
  }
}

