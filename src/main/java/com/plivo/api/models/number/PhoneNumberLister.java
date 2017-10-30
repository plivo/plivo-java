package com.plivo.api.models.number;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class PhoneNumberLister extends Lister<PhoneNumber> {

  private final String countryIso;
  private NumberType type;
  private String pattern;
  private String region;
  private String services;
  private String lata;
  private String rateCenter;

  PhoneNumberLister(String countryIso) {
    if (!Utils.allNotNull(countryIso)) {
      throw new IllegalArgumentException("countryIso cannot be null");
    }

    this.countryIso = countryIso;
  }

  public String countryIso() {
    return this.countryIso;
  }

  public NumberType type() {
    return this.type;
  }

  public String pattern() {
    return this.pattern;
  }

  public String region() {
    return this.region;
  }

  public String services() {
    return this.services;
  }

  public String lata() {
    return this.lata;
  }

  public String rateCenter() {
    return this.rateCenter;
  }

  public PhoneNumberLister type(final NumberType type) {
    this.type = type;
    return this;
  }

  public PhoneNumberLister pattern(final String pattern) {
    this.pattern = pattern;
    return this;
  }

  public PhoneNumberLister region(final String region) {
    this.region = region;
    return this;
  }

  public PhoneNumberLister services(final String services) {
    this.services = services;
    return this;
  }

  public PhoneNumberLister lata(final String lata) {
    this.lata = lata;
    return this;
  }

  public PhoneNumberLister rateCenter(final String rateCenter) {
    this.rateCenter = rateCenter;
    return this;
  }

  @Override
  protected Call<ListResponse<PhoneNumber>> obtainCall() {
    return client().getApiService().phoneNumberList(client().getAuthId(), toMap());
  }
}
