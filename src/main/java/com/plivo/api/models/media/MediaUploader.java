package com.plivo.api.models.media;

import com.plivo.api.models.base.Creator;
import com.plivo.api.models.media.MediaResponse;
import com.plivo.api.models.media.MediaUploader;
import com.plivo.api.models.message.MessageCreateResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import java.io.File;

public class MediaUploader extends Creator<MediaResponse> {

  private  String[] fileName = null;
  RequestBody body = null;

  MediaUploader(String[] filename){

  }
  public MediaUploader fileName(final String[] fileName) {
    this.fileName = fileName;
    for (i = 0; i < this.fileName.length; i++) { 
    MediaType mediaType = MediaType.parse("application/json");
    this.body = new MultipartBody.Builder().setType(MultipartBody.FORM)
      .addFormDataPart("file","filename",
        RequestBody.create(MediaType.parse("application/octet-stream"),
          new File(this.fileName[i])))
      .build();
    return this;
    }
  }
  @Override
  protected Call<MediaResponse> obtainCall() {
    return client().getApiService().uploadMedia(client().getAuthId(), this);
  }

}

