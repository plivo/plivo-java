package com.plivo.api.models.number;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Number extends BaseResource {

  private String addedOn;
  private String alias;
  private String application;
  private String carrier;
  private String monthlyRentalRate;
  private String number;
  private NumberType numberType;
  private String region;
  private String resourceUri;
  private Boolean smsEnabled;
  private String smsRate;
  private Boolean voiceEnabled;
  private String voiceRate;
  private String subAccount;
  private Boolean active;

  public Boolean getActive() {
    return active;
  }

  public static NumberLister lister() {
    return new NumberLister();
  }

  public static NumberGetter getter(String number) {
    return new NumberGetter(number);
  }

  public static NumberCreator creator(List<String> numbers, String carrier, String region) {
    return new NumberCreator(numbers, carrier, region);
  }

  public static NumberCreator adder(List<String> numbers, String carrier, String region) {
    return creator(numbers, carrier, region);
  }

  public static NumberUpdater updater(String number) {
    return new NumberUpdater(number);
  }

  public static NumberDeleter deleter(String number) {
    return new NumberDeleter(number);
  }

  public String getSubAccount() {
    return subAccount;
  }

  public String getAddedOn() {
    return addedOn;
  }

  public String getAlias() {
    return alias;
  }

  public String getApplication() {
    return application;
  }

  public String getCarrier() {
    return carrier;
  }

  public String getMonthlyRentalRate() {
    return monthlyRentalRate;
  }

  public String getNumber() {
    return number;
  }

  public NumberType getNumberType() {
    return numberType;
  }

  public String getRegion() {
    return region;
  }

  public String getResourceUri() {
    return resourceUri;
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

  public NumberUpdater updater() {
    return Number.updater(number);
  }

  public NumberDeleter deleter() {
    return Number.deleter(number);
  }

  public NumberDeleter unrenter() {
    return deleter();
  }

  @Override
  public String getId() {
    return getNumber();
  }
}
