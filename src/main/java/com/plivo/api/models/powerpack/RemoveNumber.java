package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;

public class RemoveNumber extends Deleter<Numbers> {

  private Boolean unrent;
  private String number;

  public RemoveNumber(String id) {
    super(id);
    if (id == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.id = id;
  }


  public Boolean unrent() {
    return this.unrent;
  }

  /**
   * @param unrent Specify if the powerpack numbers should be unrent_numbers or not.
   */
  public RemoveNumber unrent(final Boolean unrent) {
    this.unrent = unrent;
    return this;
  }

  public RemoveNumber number(final String number) {
    this.number = number;
    return this;
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().powerpackNumberDelete(client().getAuthId(), id, number, this);
  }
}
