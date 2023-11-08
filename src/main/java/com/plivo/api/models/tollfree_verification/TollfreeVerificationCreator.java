package com.plivo.api.models.tollfree_verification;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class TollfreeVerificationCreator extends Creator<TollfreeVerificationCreateResponse> {

  private String profileUuid;
  private String number;
  private String usecase;
  private String usecaseSummary;
  private String messageSample;
  private String optinImageUrl;
  private String optinType;
  private String volume;
  private String additionalInformation;
  private String extraData;
  private String callbackUrl;
  private String callbackMethod;

  TollfreeVerificationCreator(String profileUuid, String number, String usecase, String usecaseSummary, String optinImageUrl,
                              String messageSample, String optinType, String volume, String additionalInformation, String extraData, String callbackUrl, String callbackMethod) {
    if (!Utils.allNotNull(profileUuid, number, usecase, usecaseSummary, optinImageUrl, optinType, volume, additionalInformation)) {
      throw new IllegalArgumentException("profileUuid, number, usecase, usecaseSummary, optinImageUrl, optinType, volume, additionalInformation must not be null");
    }

    this.profileUuid = profileUuid;
    this.number = number;
    this.usecase = usecase;
    this.usecaseSummary = usecaseSummary;
    this.messageSample = messageSample;
    this.optinImageUrl = optinImageUrl;
    this.optinType = optinType;
    this.volume = volume;
    this.additionalInformation = additionalInformation;
    this.extraData = extraData;
    this.callbackUrl = callbackUrl;
    this.callbackMethod = callbackMethod;

  }

  TollfreeVerificationCreator(String profileUuid, String number, String usecase, String usecaseSummary, String optinImageUrl,
                              String messageSample, String optinType, String volume, String additionalInformation) {
    if (!Utils.allNotNull(profileUuid, number, usecase, usecaseSummary, optinImageUrl, optinType, volume, additionalInformation)) {
      throw new IllegalArgumentException("profileUuid, number, usecase, usecaseSummary, optinImageUrl, optinType, volume, additionalInformation must not be null");
    }

    this.profileUuid = profileUuid;
    this.number = number;
    this.usecase = usecase;
    this.usecaseSummary = usecaseSummary;
    this.messageSample = messageSample;
    this.optinImageUrl = optinImageUrl;
    this.optinType = optinType;
    this.volume = volume;
    this.additionalInformation = additionalInformation;
  }

  TollfreeVerificationCreator() {}


  @Override
  protected Call<TollfreeVerificationCreateResponse> obtainCall() {
    return client().getApiService().tollfreeVerificationCreate(client().getAuthId(), this);
  }

  public String profileUuid() {
    return profileUuid;
  }

  public TollfreeVerificationCreator profileUuid(final String profileUuid) {
    this.profileUuid = profileUuid;
    return this;
  }

  public String number() {
    return number;
  }

  public TollfreeVerificationCreator number(final String number) {
    this.number = number;
    return this;
  }

  public String usecase() {
    return usecase;
  }

  public TollfreeVerificationCreator usecase(final String usecase) {
    this.usecase = usecase;
    return this;
  }

  public String callbackMethod() {
    return callbackMethod;
  }

  public TollfreeVerificationCreator callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  public String callbackUrl() {
    return callbackUrl;
  }

  public TollfreeVerificationCreator callbackUrl(final String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  public String extraData() {
    return extraData;
  }

  public TollfreeVerificationCreator extraData(final String extraData) {
    this.extraData = extraData;
    return this;
  }

  public String additionalInformation() {
    return additionalInformation;
  }

  public TollfreeVerificationCreator additionalInformation(final String additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

  public String volume() {
    return volume;
  }

  public TollfreeVerificationCreator volume(final String volume) {
    this.volume = volume;
    return this;
  }

  public String optinType() {
    return optinType;
  }

  public TollfreeVerificationCreator optinType(final String optinType) {
    this.optinType = optinType;
    return this;
  }

  public String optinImageUrl() {
    return optinImageUrl;
  }

  public TollfreeVerificationCreator optinImageUrl(final String optinImageUrl) {
    this.optinImageUrl = optinImageUrl;
    return this;
  }

  public String messageSample() {
    return messageSample;
  }

  public TollfreeVerificationCreator messageSample(final String messageSample) {
    this.messageSample = messageSample;
    return this;
  }

  public String usecaseSummary() {
    return usecaseSummary;
  }

  public TollfreeVerificationCreator usecaseSummary(final String usecaseSummary) {
    this.usecaseSummary = usecaseSummary;
    return this;
  }
}
