package com.plivo.api.models.pricing;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.base.BaseResource;

public class Pricing extends BaseResource {

  private JsonNode message;
  private JsonNode phoneNumbers;
  private JsonNode voice;
  private String countryIso;
  private Long countryCode;
  private String country;

  public static PricingGetter getter(String countryIso) {
    return new PricingGetter(countryIso);
  }

  /**
   * @return Pricing for messages.
   */
  public JsonNode getMessage() {
    return message;
  }

  /**
   * @return Pricing for phone numbers.
   */
  public JsonNode getPhoneNumbers() {
    return phoneNumbers;
  }

  /**
   * @return Pricing for voice.
   */
  public JsonNode getVoice() {
    return voice;
  }

  public String getCountryIso() {
    return countryIso;
  }

  public Long getCountryCode() {
    return countryCode;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String getId() {
    return getCountryIso();
  }
}
