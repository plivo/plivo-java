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
  private String tendlcRegistrationStatus;
  private String tendlcCampaignId;
  private String tollFreeSMSVerification;

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

  public String tendlcRegistrationStatus() {
    return this.tendlcRegistrationStatus;
  }

  public String tendlcCampaignId() {
    return this.tendlcCampaignId;
  }

  public String tollFreeSMSVerification() {
    return this.tollFreeSMSVerification;
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

  public NumberLister tendlcRegistrationStatus(final String tendlcRegistrationStatus) {
    this.tendlcRegistrationStatus = tendlcRegistrationStatus;
    return this;
  }

  public NumberLister tendlcCampaignId(final String tendlcCampaignId) {
    this.tendlcCampaignId = tendlcCampaignId;
    return this;
  }

  public NumberLister tollFreeSMSVerification(final String tollFreeSMSVerification) {
    this.tollFreeSMSVerification = tollFreeSMSVerification;
    return this;
  }

  @Override
  protected Call<ListResponse<Number>> obtainCall() {
    return client().getApiService().numberList(client().getAuthId(), toMap());
  }
}
