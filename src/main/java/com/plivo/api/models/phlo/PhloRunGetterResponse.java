package com.plivo.api.models.phlo;

import java.util.List;

import com.plivo.api.models.base.BaseResource;

public class PhloRunGetterResponse extends BaseResource {
	
  private String phloId;
  private String runId;
  private List<String> callUUIDs;
  private List<String> messageUUIDs;
  private List<String> recordingIDs;



	public List<String> getRecordingIDs() {
		return recordingIDs;
	}


	public void setRecordingIDs(List<String> recordingIDs) {
		this.recordingIDs = recordingIDs;
	}


	public String getPhloId() {
		return phloId;
	}


	public void setPhloId(String phloId) {
		this.phloId = phloId;
	}


	public String getRunId() {
		return runId;
	}


	public void setRunId(String runId) {
		this.runId = runId;
	}


	public List<String> getCallUUIDs() {
		return callUUIDs;
	}


	public void setCallUUIDs(List<String> callUUIDs) {
		this.callUUIDs = callUUIDs;
	}


	public List<String> getMessageUUIDs() {
		return messageUUIDs;
	}


	public void setMessageUUIDs(List<String> messageUUIDs) {
		this.messageUUIDs = messageUUIDs;
	}




	@Override
	public String toString() {
		return "PhloRunGetterResponse [phloId=" + phloId + ", runId=" + runId  + ", callUUIDs="
				+ callUUIDs + ", messageUUIDs=" + messageUUIDs + ", recordingUUIDs=" + recordingIDs + "]";
	}


	@Override
	public String getId() {
		
		return this.phloId;
	}

  
  
  
}
