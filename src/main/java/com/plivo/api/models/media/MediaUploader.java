package com.plivo.api.models.media;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Creator;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.activation.MimetypesFileTypeMap;

public class MediaUploader extends Creator<MediaResponse> {

  private RequestBody filesAsRequestBody = null;

  MediaUploader(String[] fileNames) throws ResourceNotFoundException{
    filesAsRequestBody = getFilesForFilenames(fileNames);
  }

  private RequestBody getFilesForFilenames(String[] fileNames) throws ResourceNotFoundException {
    Builder builder = new MultipartBody.Builder()
      .setType(MultipartBody.FORM);
    for(int i = 0; i < fileNames.length; i++) {
      File tempFile = new File(fileNames[i]);
      boolean exists = tempFile.exists();
      if(!exists)
        throw new ResourceNotFoundException("File missing " + fileNames[i]);
      try {
        System.out.println(tempFile);
        System.out.println(tempFile.toPath());
        // handle for java 8
        String content_type = "";
        if (Files.probeContentType(tempFile.toPath()) != null ){
          content_type = Files.probeContentType(tempFile.toPath());
        } else {
          Path source = Paths.get(fileNames[i]);
          MimetypesFileTypeMap m = new MimetypesFileTypeMap(source.toString());
          content_type = m.getContentType(tempFile);
        }
        builder
          .addFormDataPart("file", fileNames[i],
            RequestBody.create(MediaType.parse(content_type), tempFile));
      } catch (IOException e) {
        throw new ResourceNotFoundException("Unable to read file " + fileNames[i]);
      }
    }
    return builder.build();
  }

  public RequestBody getFilesAsRequestBody() {
    return this.filesAsRequestBody;
  }


  @Override
  public Creator<MediaResponse> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  @Override
  protected Call<MediaResponse> obtainCall() {
    return client().getApiService().uploadMedia(client().getAuthId(), this.getFilesAsRequestBody());
  }

}

