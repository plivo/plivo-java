package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResource;

public class Tollfree extends BaseResource {

  private String added_on;
  private String country_iso2;
  private String number_pool_uuid;
  private String number;
  private String uuid;
  private String account_phone_number_resource;
  private String type;

  public Tollfree(String uuid) {
    this.uuid = uuid;
  }

  public Tollfree() {
    //Introducing the dummy constructor
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
    return new PowerpackAddTollfree(uuid);
  }

  public String getNumber_pool_uuid() {
	    return number_pool_uuid;
	  }

  public String getNumber() {
  return number;
  }

  public String getType() {
  return type;
  }

  public String getAdded_on() {
  return added_on;
  }

  public String getCountry_iso2() {
  return country_iso2;
  }

  public String getAccount_phone_number_resource() {
  return account_phone_number_resource;
  }

  @Override
  public String getId() {
    return getNumber_pool_uuid();
  }

}
