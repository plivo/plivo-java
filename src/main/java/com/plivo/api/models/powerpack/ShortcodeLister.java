package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class ShortcodeLister extends Lister<Shortcode> {

  private String id;

  ShortcodeLister(String id) {

    if (!Utils.allNotNull(id)) {
      throw new IllegalArgumentException("uuid cannot be null");
    }
    this.id = id;
  }

  @Override
  protected Call<ListResponse<Shortcode>> obtainCall() {
    return client().getApiService().powerpackShortcodeList(client().getAuthId(), id, toMap());
  }
}