package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class CampaignUpdater extends Updater<CampaignUpdateResponse> {
  private String campaignId;
  private String resellerId;
  private String description;
  private String sample1;
  private String sample2;
  private String messageFlow;
  private String helpMessage;
  private String optinKeywords;
  private String optinMessage;
  private String optoutKeywords;
  private String optoutMessage;
  private String helpKeywords;

  CampaignUpdater(String campaignId, String resellerId, String description, String sample1, String sample2,
      String messageFlow, String helpMessage, String optinKeywords, String optinMessage, String optoutKeywords,
      String optoutMessage, String helpKeywords) {

    super(campaignId);

    this.resellerId = resellerId;
    this.description = description;
    this.sample1 = sample1;
    this.sample2 = sample2;
    this.messageFlow = messageFlow;
    this.helpMessage = helpMessage;
    this.optinKeywords = optinKeywords;
    this.optinMessage = optinMessage;
    this.optoutKeywords = optoutKeywords;
    this.optoutMessage = optoutMessage;
    this.helpKeywords = helpKeywords;
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