package com.plivo.api.models.tollfree_verification;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class TollfreeVerificationUpdater extends Updater<TollfreeVerificationUpdateResponse> {
  private String uuid;
  private String number;
  private String profileuuid;
  private String usecase;
  private String usecaseSummary;
  private String messageSample;
  private String optInImageURL;
  private String optInType;
  private String volume;
  private String additionalInformation;
  private String extraData;
  private String callbackURL;
  private String callbackMethod;

  public String uuid() {
    return uuid;
  }

  public TollfreeVerificationUpdater uuid(final String uuid) {
    this.uuid = uuid;
    return this;
  }

  public String number() {
    return number;
  }

  public TollfreeVerificationUpdater number(final String number) {
    this.number = number;
    return this;
  }

  public String profileuuid() {
    return profileuuid;
  }

  public TollfreeVerificationUpdater profileuuid(final String profileuuid) {
    this.profileuuid = profileuuid;
    return this;
  }

  public String usecase() {
    return usecase;
  }

  public TollfreeVerificationUpdater usecase(final String usecase) {
    this.usecase = usecase;
    return this;
  }

  public String usecaseSummary() {
    return usecaseSummary;
  }

  public TollfreeVerificationUpdater usecaseSummary(final String usecaseSummary) {
    this.usecaseSummary = usecaseSummary;
    return this;
  }

  public String messageSample() {
    return messageSample;
  }

  public TollfreeVerificationUpdater messageSample(final String messageSample) {
    this.messageSample = messageSample;
    return this;
  }

  public String optInImageURL() {
    return optInImageURL;
  }

  public TollfreeVerificationUpdater optInImageURL(final String optInImageURL) {
    this.optInImageURL = optInImageURL;
    return this;
  }

  public String optInType() {
    return optInType;
  }

  public TollfreeVerificationUpdater optInType(final String optInType) {
    this.optInType = optInType;
    return this;
  }

  public String volume() {
    return volume;
  }

  public TollfreeVerificationUpdater volume(final String volume) {
    this.volume = volume;
    return this;
  }

  public String additionalInformation() {
    return additionalInformation;
  }

  public TollfreeVerificationUpdater additionalInformation(final String additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

  public String extraData() {
    return extraData;
  }

  public TollfreeVerificationUpdater extraData(final String extraData) {
    this.extraData = extraData;
    return this;
  }

  public String callbackURL() {
    return callbackURL;
  }

  public TollfreeVerificationUpdater callbackURL(final String callbackURL) {
    this.callbackURL = callbackURL;
    return this;
  }

  public String callbackMethod() {
    return callbackMethod;
  }

  public TollfreeVerificationUpdater callbackMethod(final String callbackMethod) {
    this.callbackMethod = callbackMethod;
    return this;
  }

  public TollfreeVerificationUpdater(String id) {
    super(id);
  }

  @Override
  protected Call<TollfreeVerificationUpdateResponse> obtainCall() {
    return client().getApiService().tollfreeVerificationUpdate(client().getAuthId(), id, this);
  }
}