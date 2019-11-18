package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class FindShortcode extends Getter<Shortcode> {

  private String shortcode;
  private String uuid;

  public FindShortcode(String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }

  public FindShortcode shortcode(String shortcode) {
    this.shortcode = shortcode;
    return this;
  }

  @Override
  protected Call<Shortcode> obtainCall() {
    if (shortcode == null) {
      throw new IllegalArgumentException("number cannot be null");
    }
    return client().getApiService().powerpackFindShortcodeGet(client().getAuthId(), uuid, shortcode);
  }
}