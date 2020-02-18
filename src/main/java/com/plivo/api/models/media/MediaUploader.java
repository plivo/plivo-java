package com.plivo.api.models.media;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Creator;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import retrofit2.Call;

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
			  throw new ResourceNotFoundException("File mising " + fileNames[i]);
		  try {
			builder
			  	.addFormDataPart("file", fileNames[i],
			            RequestBody.create(MediaType.parse(Files.probeContentType(tempFile.toPath())), tempFile));
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

