package com.plivo.api.models.address;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class AddressLister extends Lister<Address> {

  private String countryIso;
  private String customerName;
  private String alias;
  private String verificationStatus;
  private String validationStatus;
  private String limit;
  private String offset;

  public AddressLister countryIso(String countryIso) {
    this.countryIso = countryIso;
    return this;
  }

  public AddressLister customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public AddressLister alias(String alias) {
    this.alias = alias;
    return this;
  }

  public AddressLister verificationStatus(String verificationStatus) {
    this.verificationStatus = verificationStatus;
    return this;
  }

  public AddressLister validationStatus(String validationStatus) {
    this.validationStatus = validationStatus;
    return this;
  }

  public AddressLister limit(String limit) {
    this.limit = limit;
    return this;
  }

  public AddressLister offset(String offset) {
    this.offset = offset;
    return this;
  }

  @Override
  protected Call<ListResponse<Address>> obtainCall() {
    return client().getApiService().addressList(client().getAuthId(), toMap());
  }
}
