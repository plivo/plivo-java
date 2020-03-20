package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResource;

public class NumberPool extends BaseResource {

  public Shortcode shortcodes;
  public Numbers numbers;
  private String uuid;
  public Tollfree tollfree;

  public NumberPool(String uuid) {
    this.uuid = uuid;
    shortcodes = new Shortcode(uuid);
    numbers = new Numbers(uuid);
    tollfree = new Tollfree(uuid);
  }

  public String getNumberPoolId() {
    return uuid;
  }

  @Override
  public String getId() {
    return getNumberPoolId();
  }

}
