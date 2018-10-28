package com.plivo.api.models.account;

import com.plivo.api.models.base.Deleter;
import com.plivo.api.util.Utils;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class SubaccountDeleter extends Deleter<Subaccount> {

  private Boolean cascade;

  public SubaccountDeleter(String id) {
    super(id);

    if (!Utils.isSubaccountIdValid(id)) {
      throw new IllegalArgumentException("invalid subaccount ID");
    }
  }

  /**
   * @return Specify if the subaccount should be cascade deleted or not.
   */
  public Boolean cascade() {
    return this.cascade;
  }

  /**
   * @param cascade Specify if the subaccount should be cascade or not.
   */
  public SubaccountDeleter cascade(final Boolean cascade) {
    this.cascade = cascade;
    return this;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().subaccountDelete(client().getAuthId(), id, this);
  }
}
