package com.plivo.api.models.account;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class SubaccountCreator extends Creator<SubaccountCreateResponse> {

  private final String name;
  private Boolean enabled;

  /**
   * @param name Name of the subaccount.
   */
  SubaccountCreator(String name) {
    if (!Utils.allNotNull(name)) {
      throw new IllegalArgumentException("name must not be null");
    }

    this.name = name;
  }

  /**
   * @return Name of the subaccount.
   */
  public String name() {
    return name;
  }

  /**
   * @return Specify if the subaccount should be enabled or not. Takes a value of True or False.
   * Defaults to False
   */
  public Boolean enabled() {
    return this.enabled;
  }

  /**
   * @param enabled Specify if the subaccount should be enabled or not. Takes a value of True or
   * False. Defaults to False
   */
  public SubaccountCreator enabled(final Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  protected Call<SubaccountCreateResponse> obtainCall() {
    return client().getApiService().subaccountCreate(client().getAuthId(), this);
  }
}
