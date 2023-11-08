package com.plivo.api.models.tollfree_verification;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TollfreeVerification extends BaseResource {
  private String uuid;
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
  private String status;
  private String errorMessage;
  private String created;
  private String lastModified;

  public static TollfreeVerificationCreator creator(String profileUuid, String number, String usecase, String usecaseSummary, String optinImageUrl,
                                                    String messageSample, String optinType, String volume, String additionalInformation,
                                                    String extraData, String callbackUrl, String callbackMethod) {

    return new TollfreeVerificationCreator(profileUuid, number, usecase, usecaseSummary, optinImageUrl,
      messageSample, optinType, volume, additionalInformation,extraData, callbackUrl, callbackMethod);
  }

  public static TollfreeVerificationCreator creator(String profileUuid, String number, String usecase, String usecaseSummary, String optinImageUrl,
                                                    String messageSample, String optinType, String volume, String additionalInformation) {

    return new TollfreeVerificationCreator(profileUuid, number, usecase, usecaseSummary, optinImageUrl,
      messageSample, optinType, volume, additionalInformation);
  }

  public static TollfreeVerificationCreator creator() {
    return new TollfreeVerificationCreator();
  }


  public static TollfreeVerificationDeleter deleter(String uuid) {
    return new TollfreeVerificationDeleter(uuid);
  }

  public static TollfreeVerificationGetter getter(String uuid) {
    return new TollfreeVerificationGetter(uuid);
  }

  public static TollfreeVerificationLister lister() {
    return new TollfreeVerificationLister();
  }

  public static TollfreeVerificationUpdater updater(String uuid) {
    return new TollfreeVerificationUpdater(uuid);
  }

  public TollfreeVerificationDeleter deleter() {
    return new TollfreeVerificationDeleter(uuid);
  }

  public TollfreeVerificationUpdater updater() {
    return new TollfreeVerificationUpdater(uuid);
  }


  @Override
  public String getId() {
    return getUuid();
  }

  public String getUuid() {
    return uuid;
  }

  public String getProfileUuid() {
    return profileUuid;
  }

  public String getNumber() {
    return number;
  }

  public String getUsecase() {
    return usecase;
  }

  public String getUsecaseSummary() {
    return usecaseSummary;
  }

  public String getMessageSample() {
    return messageSample;
  }

  public String getOptinImageUrl() {
    return optinImageUrl;
  }

  public String getOptinType() {
    return optinType;
  }

  public String getVolume() {
    return volume;
  }

  public String getAdditionalInformation() {
    return additionalInformation;
  }

  public String getExtraData() {
    return extraData;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }

  public String getCallbackMethod() {
    return callbackMethod;
  }

  public String getStatus() {
    return status;
  }

  public String created() {
    return created;
  }

  public String lastModified() {
    return lastModified;
  }
}
