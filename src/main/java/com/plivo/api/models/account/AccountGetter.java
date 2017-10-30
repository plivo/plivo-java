package com.plivo.api.models.account;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class AccountGetter extends Getter<Account> {

  public AccountGetter() {
    super(""); // This is the only case where we don't care about the ID
  }

  @Override
  protected Call<Account> obtainCall() {
    return client().getApiService().accountGet(client().getAuthId());
  }
}
