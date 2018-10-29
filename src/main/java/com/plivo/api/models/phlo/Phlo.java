package com.plivo.api.models.phlo;

import com.plivo.api.models.base.BaseResource;

public class Phlo extends BaseResource {

  private String phloId;
  private String name;
  private String createdOn;

  public static PhloUpdater updater(String phloId){
    return new PhloUpdater(phloId);
  }

  public static PhloGetter getter(String phloId) {
    return new PhloGetter(phloId);
  }

  @Override
  public String getId() {
    return phloId;
  }

  public String getName() {
    return name;
  }
}
