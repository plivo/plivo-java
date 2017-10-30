package com.plivo.api.models.number;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;

public class NumberCreator extends Creator<NumberCreateResponse> {

  private List<String> numbers = new ArrayList<>();
  private String carrier;
  private String region;
  private NumberType numberType;
  private String appId;
  private String subaccount;

  NumberCreator(List<String> numbers, String carrier, String region) {
    if (!Utils.allNotNull(carrier, numbers, region)) {
      throw new IllegalStateException("carrier, numbers and region are required");
    }

    this.numbers = numbers;
    this.carrier = carrier;
    this.region = region;
  }

  public List<String> numbers() {
    return this.numbers;
  }

  public String carrier() {
    return this.carrier;
  }

  public String region() {
    return this.region;
  }

  public NumberType numberType() {
    return this.numberType;
  }

  public String appId() {
    return this.appId;
  }

  public String subaccount() {
    return this.subaccount;
  }

  public NumberCreator numberType(final NumberType numberType) {
    this.numberType = numberType;
    return this;
  }

  public NumberCreator appId(final String appId) {
    this.appId = appId;
    return this;
  }

  public NumberCreator subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }

  @Override
  protected Call<NumberCreateResponse> obtainCall() {
    return client().getApiService().numberCreate(client().getAuthId(), this);
  }

  public NumberCreateResponse add() throws IOException, PlivoRestException {
    return create();
  }
}
