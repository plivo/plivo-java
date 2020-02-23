package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResource;

public class Tollfree extends BaseResource {

  private String added_on;
  private String country_iso2;
  private String number_pool_uuid;
  private String tollfree;
  private String uuid;
  private String number_pool_id;

  public Tollfree(String uuid) {
    this.uuid = uuid;
  }

  public Tollfree getter() {
    return this;
  }

  public TollfreeLister list() {
    return new TollfreeLister(uuid);
  }

  public FindTollfree find() {
    return new FindTollfree(uuid);
  }

  public RemoveTollfree remove() {
    return new RemoveTollfree(uuid);
  }

  public PowerpackAddTollfree add() {
    return new PowerpackAddTollfree(getNumberPoolId());
  }

  public String getNumberPoolId() {
    return number_pool_uuid;
  }

  public String getTollfree() {
    return tollfree;
  }


  public String getAddedOn() {
    return added_on;
  }

  public String getCountryIso2() {
    return country_iso2;
  }

  @Override
  public String getId() {
    return getNumberPoolId();
  }

}
