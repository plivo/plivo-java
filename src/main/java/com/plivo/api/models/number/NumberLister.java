package com.plivo.api.models.number;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.PropertyFilter;
import retrofit2.Call;

public class NumberLister extends Lister<Number> {

  private NumberType numberType;
  private String numberStartswith;
  private String subaccount;
  private String alias;
  private String services;
  private String tendlcRegistrationStatus;
  private String tendlcCampaignId;
  private String tollFreeSmsVerification;
  private PropertyFilter<String> renewalDate;
  private String cnamLookup;
  private String cnam;

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

  public String tollFreeSmsVerification() {
    return this.tollFreeSmsVerification;
  }
  public PropertyFilter<String> renewalDate() {
    return this.renewalDate;
  }
  public String cnamLookup() {
    return this.cnamLookup;
  }
  public String cnam() {
    return this.cnam;
  }

  public NumberLister numberType(final NumberType numberType) {
    this.numberType = numberType;
    return this;
  }

  public NumberLister renewalDate(final PropertyFilter<String> renewalDate) {
    this.renewalDate = renewalDate;
    return this;
  }

  public NumberLister cnamLookup(final String cnamLookup) {
    this.cnamLookup = cnamLookup;
    return this;
  }

  public NumberLister cnam(final String cnam) {
    this.cnam = cnam;
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

  public NumberLister tollFreeSMSVerification(final String tollFreeSmsVerification) {
    this.tollFreeSmsVerification = tollFreeSmsVerification;
    return this;
  }

  @Override
  protected Call<ListResponse<Number>> obtainCall() {
    return client().getApiService().numberList(client().getAuthId(), toMap());
  }
}
