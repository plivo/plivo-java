package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResource;

public class Numbers extends BaseResource {

  private String number_pool_uuid;
  private String number;
  private String type;
  private String country_iso2;
  private String account_phone_number_resource;
  private String added_on;
  private String uuid;

  public Numbers(String uuid) {
    this.uuid = uuid;
  }

  public Numbers(){

  }

  public RemoveNumber remove() {
    return new RemoveNumber(uuid);
  }

  public PowerpackNumberLister list() {
    return new PowerpackNumberLister(uuid);
  }

  public PowerpackFindNumber find() {
    return new PowerpackFindNumber(uuid);
  }

  public PowerpackAddNumber add() {
    return new PowerpackAddNumber(uuid);
  }

  public PowerpackNumberLister count() {
    return new PowerpackNumberLister(uuid);
  }

  public BuyAddNumbers buy_add_number() {
    return new BuyAddNumbers(uuid);
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
