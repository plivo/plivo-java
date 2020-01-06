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

  public Numbers getter() {
    return this;
  }
  public Numbers(){

  }
  public String getNumberPoolId() {
    return number_pool_uuid;
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

  public String getNumber() {
    return number;
  }

  public String getType() {
    return type;
  }

  public String getAddedOn() {
    return added_on;
  }

  public String getCountryIso2() {
    return country_iso2;
  }

  public String getAccountPhoneNumberResource() {
    return account_phone_number_resource;
  }

  @Override
  public String getId() {
    return getNumberPoolId();
  }

}
