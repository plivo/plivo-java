package com.plivo.api.models.number;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class NumberLister extends Lister<Number> {

  private NumberType numberType;
  private String numberStartswith;
  private String subaccount;
  private String alias;
  private String services;

  public NumberType numberType() {
    return this.numberType;
  }

  public String numberStartswith() {
    return this.numberStartswith;
  }

  public String subaccount() {
    return this.subaccount;
  }

  public String alias() {
    return this.alias;
  }

  public String services() {
    return this.services;
  }

  public NumberLister numberType(final NumberType numberType) {
    this.numberType = numberType;
    return this;
  }

  public NumberLister numberStartswith(final String numberStartswith) {
    this.numberStartswith = numberStartswith;
    return this;
  }

  public NumberLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  public NumberLister alias(final String alias) {
    this.alias = alias;
    return this;
  }

  public NumberLister services(final String services) {
    this.services = services;
    return this;
  }

  @Override
  protected Call<ListResponse<Number>> obtainCall() {
    return client().getApiService().numberList(client().getAuthId(), toMap());
  }
}
