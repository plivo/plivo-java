package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResource;

public class Shortcode extends BaseResource {

  private String added_on;
  private String country_iso2;
  private String number_pool_uuid;
  private String shortcode;
  private String uuid;
  private String number_pool_id;

  public Shortcode(String uuid) {
    this.uuid = uuid;
  }

  public Shortcode getter() {
    return this;
  }

  public ShortcodeLister list() {
    return new ShortcodeLister(uuid);
  }

  public FindShortcode find() {
    return new FindShortcode(uuid);
  }

  public String getNumberPoolId() {
    return number_pool_uuid;
  }

  public String getShortcode() {
    return shortcode;
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
