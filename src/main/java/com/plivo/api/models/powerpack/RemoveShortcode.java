package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;

public class RemoveShortcode extends Deleter<Shortcode> {

  private String shortcode;

  public RemoveShortcode(String id) {
    super(id);
    if (id == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.id = id;
  }

  public RemoveShortcode shortcode(final String shortcode) {
    this.shortcode = shortcode;
    return this;
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().powerpackShortcodeDelete(client().getAuthId(), id, shortcode, this);
  }
}