package com.plivo.api.models.account;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class AccountUpdater extends Updater<AccountUpdateResponse> {

  private String name;
  private String city;
  private String address;

  public AccountUpdater() {
    super("");
  }

  /**
   * @return Name of the account holder or business.
   */
  public String name() {
    return this.name;
  }

  /**
   * @return City of the account holder.
   */
  public String city() {
    return this.city;
  }

  /**
   * @return Address of the account holder.
   */
  public String address() {
    return this.address;
  }

  /**
   * @param name Name of the account holder or business.
   */
  public AccountUpdater name(final String name) {
    this.name = name;
    return this;
  }

  /**
   * @param city City of the account holder.
   */
  public AccountUpdater city(final String city) {
    this.city = city;
    return this;
  }

  /**
   * @param address Address of the account holder.
   */
  public AccountUpdater address(final String address) {
    this.address = address;
    return this;
  }

  @Override
  protected Call<AccountUpdateResponse> obtainCall() {
    return client().getApiService().accountModify(client().getAuthId(), this);
  }
}
