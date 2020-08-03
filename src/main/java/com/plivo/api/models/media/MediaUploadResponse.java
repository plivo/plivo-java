package com.plivo.api.models.media;

public class MediaUploadResponse {
  private  String contentType;
  private String fileName;
  private String mediaId;
  private String mediaUrl;
  private int size;
  private int statusCode;
  private String uploadTime;
  private String status;

  public String getContentType() {
    return contentType;
  }

  public int getStatusCode(){
    return statusCode;
  }
  public String getStatus(){
    return  status;
  }
  public String getFileName() {
    return fileName;
  }
  public String getMediaId() {
    return mediaId;
  }

  public int getSize() {
    return size;
  }


  public String getMediaUrl() {
    return mediaUrl;
  }

  public String getUploadTime() {
    return uploadTime;
  }
}
