package com.plivo.api.models.powerpack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;

public class Shortcode extends BaseResource {

  private String added_on;
  private String country_iso2;
  private String number_pool_uuid;
  private String number;
  private String uuid;
  private String type;
  private String account_phone_number_resource;

  public Shortcode(String uuid) {
    this.uuid = uuid;
  }
  
  @JsonIgnore
  public Shortcode getter() {
	    return this;
	  }

  public ShortcodeLister list() {
    return new ShortcodeLister(uuid);
  }

  public FindShortcode find() {
    return new FindShortcode(uuid);
  }

  public RemoveShortcode remove() {
    return new RemoveShortcode(uuid);
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
