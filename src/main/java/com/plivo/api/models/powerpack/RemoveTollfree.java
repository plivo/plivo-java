package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;

public class RemoveTollfree extends Deleter<Tollfree> {

  private Boolean unrent;
  private String number;
  private String tollfree;

  public RemoveTollfree(String id) {
    super(id);
    if (id == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.id = id;
    this.unrent = Boolean.FALSE;
  }


  public Boolean unrent() {
    return this.unrent;
  }

  /**
   * @param unrent Specify if the powerpack numbers should be unrent_numbers or not.
   */
  public RemoveTollfree unrent(final Boolean unrent) {
    this.unrent = unrent;
    return this;
  }

  public RemoveTollfree tollfree(final String tollfree) {
    this.tollfree = tollfree;
    return this;
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().powerpackTollfreeDelete(client().getAuthId(), id, tollfree, this);
  }
}
