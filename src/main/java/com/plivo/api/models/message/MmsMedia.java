package com.plivo.api.models.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonIgnoreProperties(value = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MmsMedia extends BaseResource {
	private String mediaId;
    private String fileName;
    private String contentType;
    private long size;
    private String uploadTime;
    private String mediaUrl;
    private String messageUuid;
  
  public static MmsMediaLister listMedia(String message_uuid) {
      return new MmsMediaLister(message_uuid);
  }

  public String getContentType() {
    return contentType;
  }

  public String getMediaId() {
    return mediaId;
  }

  public String getMediaUrl() {
    return mediaUrl;
  }

  public String getMessageUuid() {
    return messageUuid;
  }

  public long getSize() {
    return size;
  }
  
  public String getFileName() {
	    return fileName;
	  }
  
  public String getUploadTime() {
	    return uploadTime;
	  }

  @Override
  public String getId() {
    return getMediaId();
  }
}