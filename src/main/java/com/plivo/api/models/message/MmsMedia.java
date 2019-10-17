package com.plivo.api.models.message;

import com.plivo.api.models.base.BaseResource;

public class MmsMedia extends BaseResource {
  private String content_type;
  private String media_id;
  private String media_url;
  private String message_uuid;
  private long size;

  public String getContentType() {
    return content_type;
  }

  public String getMediaId() {
    return media_id;
  }

  public String getMediaUrl() {
    return media_url;
  }

  public String getMessageUuid() {
    return message_uuid;
  }

  public long getSize() {
    return size;
  }

  @Override
  public String getId() {
    return getMediaId();
  }
}