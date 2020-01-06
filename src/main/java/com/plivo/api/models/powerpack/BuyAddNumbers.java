package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.number.PhoneNumber;
import retrofit2.Call;

public class BuyAddNumbers extends Getter<Numbers> {

  private String number;
  private String uuid;
  private String country_Iso2;
  private Boolean rent;

  public BuyAddNumbers(String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("numberpool uuid cannot be null");
    }
    this.uuid = uuid;
    this.rent = Boolean.TRUE;
  }

  public BuyAddNumbers country_Iso2(String country_Iso2) {
    this.country_Iso2 = country_Iso2;
    return this;
  }

  public BuyAddNumbers rent() {
    this.rent = Boolean.TRUE;
    return this;
  }

  public BuyAddNumbers number(String number) {
    this.number = number;
    return this;
  }

  @Override
  protected Call<Numbers> obtainCall() {
    if (number == null) {
      try {
        ListResponse<PhoneNumber> numbers = PhoneNumber.lister(country_Iso2).list();
        if (numbers.getObjects().size() > 0) {
          number = numbers.getObjects().get(0).getNumber();
        }
      } catch (Exception e) {
      }
    }
    return client().getApiService().powerpackBuyAddNumberCreate(client().getAuthId(), uuid, number, this);
  }
}