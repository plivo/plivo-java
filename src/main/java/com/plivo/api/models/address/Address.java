package com.plivo.api.models.address;

import com.plivo.api.models.base.BaseResource;

// FIX ME : documentation
public class Address extends BaseResource {

  private String id;
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
  private String fiscalIdentificationCode;
  private String streetCode;
  private String municipalCode;
  private String validationStatus;
  private String verificationStatus;
  private String subaccount;
  private String url;
  private AddressProofType addressProofType;

  public static AddressCreator creator(
    String countryIso, String salutation, String firstName, String lastName,
    String addressLine1, String addressLine2, String city, String region, String postalCode) {
    return new AddressCreator(countryIso, salutation, firstName, lastName, addressLine1, addressLine2, city, region, postalCode);
  }

  public static AddressUpdater updater(String id){
    return new AddressUpdater(id);
  }

  public static AddressGetter getter(String id) {
    return new AddressGetter(id);
  }

  public static AddressDeleter deleter(String id) {
    return new AddressDeleter(id);
  }

  public static AddressLister lister(){
    return new AddressLister();
  }

  public String getCountryIso() {
    return countryIso;
  }

  public String getAlias() {
    return alias;
  }

  public String getSalutation() {
    return salutation;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public String getCity() {
    return city;
  }

  public String getRegion() {
    return region;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getFiscalIdentificationCode() {
    return fiscalIdentificationCode;
  }

  public String getStreetCode() {
    return streetCode;
  }

  public String getMunicipalCode() {
    return municipalCode;
  }

  public String getValidationStatus() { return validationStatus; }

  public String getVerificationStatus() {
    return verificationStatus;
  }

  public String getSubaccount() {
    return subaccount;
  }

  public String getUrl() {
    return url;
  }

  public AddressProofType getAddressProofType() {
    return addressProofType;
  }

  @Override
  public String getId() {
    return id;
  }
}
