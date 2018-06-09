package com.plivo.api.models.address;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class AddressCreator extends Creator<AddressCreateResponse> {

  private String countryIso;
  private String alias;
  private String salutation;
  private String firstName;
  private String lastName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String region;
  private String postalCode;
  private String file;
  private Boolean autoCorrectAddress;
  private AddressProofType addressProofType;

  public String countryIso() {
    return countryIso;
  }

  public String salutation() {
    return salutation;
  }

  public String firstName() {
    return firstName;
  }

  public String lastName() {
    return lastName;
  }

  public String addressLine1() {
    return addressLine1;
  }

  public String addressLine2() {
    return addressLine2;
  }

  public String city() {
    return city;
  }

  public String region() {
    return region;
  }

  public String postalCode() {
    return postalCode;
  }

  public String file() {
    return file;
  }

  public Boolean autoCorrectAddress() {
    return autoCorrectAddress;
  }

  public AddressProofType addressProofType() {
    return addressProofType;
  }

  public AddressCreator(String countryIso, String salutation, String firstName, String lastName,
                        String addressLine1, String addressLine2, String city, String region, String postalCode) {
    if (!Utils.allNotNull(countryIso, salutation, firstName, lastName,
      addressLine1, addressLine2, city, region, postalCode)) {
      throw new IllegalArgumentException("countryIso, salutation, firstName, lastName," +
        "addressLine1, addressLine2, city, region and postalCode must not be null");
    }
    this.countryIso = countryIso;
    this.salutation = salutation;
    this.firstName = firstName;
    this.lastName = lastName;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.city = city;
    this.region = region;
    this.postalCode = postalCode;
  }

  public AddressCreator countryIso(String countryIso) {
    this.countryIso = countryIso;
    return this;
  }

  public AddressCreator alias(String alias) {
    this.alias = alias;
    return this;
  }

  public AddressCreator salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  public AddressCreator firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AddressCreator lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public AddressCreator addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public AddressCreator addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public AddressCreator city(String city) {
    this.city = city;
    return this;
  }

  public AddressCreator region(String region) {
    this.region = region;
    return this;
  }

  public AddressCreator postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  public AddressCreator file(String file) {
    this.file = file;
    return this;
  }

  public AddressCreator autoCorrectAddress(Boolean autoCorrectAddress) {
    this.autoCorrectAddress = autoCorrectAddress;
    return this;
  }

  public AddressCreator addressProofType(AddressProofType addressProofType) {
    this.addressProofType = addressProofType;
    return this;
  }

  @Override
  protected Call<AddressCreateResponse> obtainCall() {
    return client().getApiService().addressCreate(client().getAuthId(), this);
  }
}


