package com.plivo.api.models.phlo;

import com.plivo.api.models.base.BaseResource;

public class Phlo extends BaseResource {

  private String phloId;
  private String name;
  private String createdOn;
  private String runID;


	public static PhloUpdater updater(String phloId){
    return new PhloUpdater(phloId);
  }

  public static PhloGetter getter(String phloId) {
    return new PhloGetter(phloId);
  }
  
  public static PhloRunGetter phloRunGetter(String phloId, String runId) {
    return new PhloRunGetter(phloId, runId);
  }
  
  public String getRunID() {
		return runID;
	}

	public void setRunID(String runID) {
		this.runID = runID;
	}
  @Override
  public String getId() {
    return phloId;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setPhloId(String phloId) {
    this.phloId = phloId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public String getName() {
    return name;
  }
}
