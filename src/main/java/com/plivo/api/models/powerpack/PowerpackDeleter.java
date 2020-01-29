package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;

public class PowerpackDeleter extends Deleter<Powerpack> {

  private Boolean unrent_numbers;

  public PowerpackDeleter(String id) {
    super(id);
    if (id == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.id = id;
    this.unrent_numbers = Boolean.TRUE;
  }

  public Boolean unrent_numbers() {
    return this.unrent_numbers;
  }

  /**
   * @param unrent_numbers Specify if the powerpack numbers should be unrent_numbers or not.
   */
  public PowerpackDeleter unrent_numbers(final Boolean unrent_numbers) {
    this.unrent_numbers = unrent_numbers;
    return this;
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().powerpackDeleter(client().getAuthId(), id, this);
  }

}
