package com.plivo.api.models.number;

import com.plivo.api.models.base.BaseResource;

public class PhoneNumber extends BaseResource {

  private String country;
  private Integer lata;
  private String monthlyRentalRate;
  private String number;
  private String prefix;
  private String rateCenter;
  private String region;
  private String resourceUri;
  private String restriction;
  private String restrictionText;
  private String setupRate;
  private Boolean smsEnabled;
  private String smsRate;
  private Boolean voiceEnabled;
  private String voiceRate;
  private NumberType type;

  public static PhoneNumberLister lister(String countryCode) {
    return new PhoneNumberLister(countryCode);
  }

  public static PhoneNumberCreator creator(String number) {
    return new PhoneNumberCreator(number);
  }

  public static PhoneNumberCreator buyer(String number) {
    return PhoneNumber.creator(number);
  }

  public NumberType getType() {
    return type;
  }

  public String getCountry() {
    return country;
  }

  public Integer getLata() {
    return lata;
  }

  public String getMonthlyRentalRate() {
    return monthlyRentalRate;
  }

  public String getNumber() {
    return number;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getRateCenter() {
    return rateCenter;
  }

  public String getRegion() {
    return region;
  }

  public String getResourceUri() {
    return resourceUri;
  }

  public String getRestriction() {
    return restriction;
  }

  public String getRestrictionText() {
    return restrictionText;
  }

  public String getSetupRate() {
    return setupRate;
  }

  public Boolean getSmsEnabled() {
    return smsEnabled;
  }

  public String getSmsRate() {
    return smsRate;
  }

  public Boolean getVoiceEnabled() {
    return voiceEnabled;
  }

  public String getVoiceRate() {
    return voiceRate;
  }

  public PhoneNumberCreator creator() {
    return new PhoneNumberCreator(number);
  }

  public PhoneNumberCreator buyer() {
    return creator();
  }

  @Override
  public String getId() {
    return getNumber();
  }
}
