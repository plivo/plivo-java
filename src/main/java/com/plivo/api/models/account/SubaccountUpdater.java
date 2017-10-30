package com.plivo.api.models.account;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class SubaccountUpdater extends Updater<SubaccountUpdateResponse> {

  private final String name;
  private Boolean enabled;

  /**
   * @param subauthId Authentication ID of the subaccount to update.
   * @param name Name of the subaccount
   */
  public SubaccountUpdater(String subauthId, String name) {
    super(subauthId);
    this.name = name;
  }

  /**
   * @return Name of the subaccount
   */
  public String name() {
    return name;
  }

  /**
   * @return Specify if the subaccount should be enabled or not.
   */
  public Boolean enabled() {
    return this.enabled;
  }

  /**
   * @param enabled Specify if the subaccount should be enabled or not.
   */
  public SubaccountUpdater enabled(final Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  protected Call<SubaccountUpdateResponse> obtainCall() {
    return client().getApiService().subaccountModify(client().getAuthId(), id, this);
  }
}
