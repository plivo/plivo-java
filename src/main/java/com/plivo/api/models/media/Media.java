package com.plivo.api.models.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.base.BaseResource;

public class Media extends BaseResource{

  private  String mediaId;
  private  String fileName;
  private String contentType;
  private int size;
  private String uploadTime;
  private String url;
  private String status;
  private int statusCode;

  public static MediaUploader creator(
    String[] fileName) {
    return new MediaUploader(fileName);
  }


  public static MediaGetter getter(String id) {
    return new MediaGetter(id);
  }

  public static MediaLister lister(){
    return new MediaLister();
  }

  public String getMediaId() {
    return mediaId ;
  }

  public String getFileName(){
    return fileName;
  }
  public String getContentType(){
    return  contentType;
  }

  public int getSize(){
    return  size;
  }
  public String getUploadTime(){
    return  uploadTime;
  }

  public String getUrl(){
    return url;
  }

  public String getStatus()
  {
    return  status;
  }
  public int getStatusCode(){
    return  statusCode;
  }

  @Override
  public String getId() {
    return mediaId;
  }
}
