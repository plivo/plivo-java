package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;


import java.io.IOException;

public class CallRecordCreator extends Creator<CallRecordCreateResponse> {

  private final String id;
  private Long timeLimit;
  private String fileFormat;
  private String callbackMethod;
  private String callbackUrl;
  private String transcriptionUrl;
  private String transcriptionMethod;
  private String transcriptionType;


  public CallRecordCreator(String id)
  {
    this.id = id;
  }
  public Long timeLimit() {
	    return this.timeLimit;
	  }
  public String fileFormat() {
	    return this.fileFormat;
	  }
  public String callbackMethod() {
	    return this.callbackMethod;
	  }
  public String callbackUrl() {
	    return this.callbackUrl;
	  }
  public String transcriptionUrl() {
	    return this.transcriptionUrl;
	  }
  public String transcriptionMethod() {
	    return this.transcriptionMethod;
	  }
  public String transcriptionType() {
	    return this.transcriptionType;
	  }

  @Override
  protected retrofit2.Call<CallRecordCreateResponse> obtainCall() {
    return client().getApiService().callRecordCreate(client().getAuthId(), id, this);
  }

  public CallRecordCreateResponse record() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public CallRecordCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }
  public CallRecordCreator timeLimit(final Long timeLimit) {
	    this.timeLimit = timeLimit;
	    return this;
	  }
  public CallRecordCreator fileFormat(final String fileFormat) {
	    this.fileFormat = fileFormat;
	    return this;
	  }
  public CallRecordCreator callbackMethod(final String callbackMethod) {
	    this.callbackMethod = callbackMethod;
	    return this;
	  }
  public CallRecordCreator callbackUrl(final String callbackUrl) {
	    this.callbackUrl = callbackUrl;
	    return this;
	  }
  public CallRecordCreator transcriptionUrl(final String transcriptionUrl) {
	    this.transcriptionUrl = transcriptionUrl;
	    return this;
	  }
  public CallRecordCreator transcriptionMethod(final String transcriptionMethod) {
	    this.transcriptionMethod = transcriptionMethod;
	    return this;

}
  public CallRecordCreator transcriptionType(final String transcriptionType) {
	    this.transcriptionType = transcriptionType;
	    return this;

}

}
