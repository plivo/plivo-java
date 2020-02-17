package com.plivo.api.models.media;

import java.io.File;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Creator;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import retrofit2.Call;

public class MediaUploader extends Creator<MediaResponse> {

  private RequestBody files = null;

  MediaUploader(String[] fileNames) throws ResourceNotFoundException{
	  files = getFilesForFilenames(fileNames);
  }
  
  private RequestBody getFilesForFilenames(String[] fileNames) throws ResourceNotFoundException {
	  Builder builder = new MultipartBody.Builder()
			  				.setType(MultipartBody.FORM);
	  for(int i = 0; i < fileNames.length; i++) {
		  File tempFile = new File(fileNames[i]);
		  boolean exists = tempFile.exists();
		  if(!exists)
			  throw new ResourceNotFoundException("File mising " + fileNames[i]);
		  builder
		  	.addFormDataPart("file", fileNames[i],
		            RequestBody.create(null, tempFile));
	  }
	  return builder.build();
  }
  

  @Override
  public Creator<MediaResponse> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  @Override
  protected Call<MediaResponse> obtainCall() {
    return client().getApiService().uploadMedia(client().getAuthId(), this.files);
  }

}

