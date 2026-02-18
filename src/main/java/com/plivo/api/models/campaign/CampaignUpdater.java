package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class CampaignUpdater extends Updater<CampaignUpdateResponse> {
  private String campaignId;
  private String resellerId;
  private String description;
  private String sample1;
  private String sample2;
  private String sample3;
  private String sample4;
  private String sample5;
  private String messageFlow;
  private String helpMessage;
  private String optinKeywords;
  private String optinMessage;
  private String optoutKeywords;
  private String optoutMessage;
  private String helpKeywords;
  private String termsAndConditionsLink;
  private String privacyPolicyLink;

  CampaignUpdater(String campaignId, String resellerId, String description, String sample1, String sample2, String sample3, String sample4, String sample5,
      String messageFlow, String helpMessage, String optinKeywords, String optinMessage, String optoutKeywords,
      String optoutMessage, String helpKeywords, String termsAndConditionsLink, String privacyPolicyLink) {

    super(campaignId);

    this.resellerId = resellerId;
    this.description = description;
    this.sample1 = sample1;
    this.sample2 = sample2;
    this.sample3 = sample3;
    this.sample4 = sample4;
    this.sample5 = sample5;
    this.messageFlow = messageFlow;
    this.helpMessage = helpMessage;
    this.optinKeywords = optinKeywords;
    this.optinMessage = optinMessage;
    this.optoutKeywords = optoutKeywords;
    this.optoutMessage = optoutMessage;
    this.helpKeywords = helpKeywords;
    this.termsAndConditionsLink = termsAndConditionsLink;
    this.privacyPolicyLink = privacyPolicyLink;
  }

  public String campaignId() {
    return this.campaignId;
  }

  public String resellerId() {
    return this.resellerId;
  }

  public String description() {
    return this.description;
  }

  public String sample1() {
    return this.sample1;
  }

  public String sample2() {
    return this.sample2;
  }

  public String sample3() {
    return this.sample3;
  }

  public String sample4() {
    return this.sample4;
  }

  public String sample5() {
    return this.sample5;
  }

  public String termsAndConditionsLink() {
    return this.termsAndConditionsLink;
  }

  public String privacyPolicyLink() {
    return this.privacyPolicyLink;
  }

  public String messageFlow() {
    return this.messageFlow;
  }

  public String helpMessage() {
    return this.helpMessage;
  }

  public String optinKeywords() {
    return this.optinKeywords;
  }

  public String optinMessage() {
    return this.optinMessage;
  }

  public String optoutKeywords() {
    return this.optoutKeywords;
  }

  public String optoutMessage() {
    return this.optoutMessage;
  }

  public String helpKeywords() {
    return this.helpKeywords;
  }

  @Override
  protected Call<CampaignUpdateResponse> obtainCall() {
    return client().getApiService().updateCampaign(client().getAuthId(), id, this);
  }
}