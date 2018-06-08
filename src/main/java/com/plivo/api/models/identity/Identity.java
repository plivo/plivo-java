package com.plivo.api.models.identity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

// FIX ME: documentation
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Identity extends BaseResource {

  private String id;
  private String countryIso;
  private String alias;
  private String salutation;
  private String firstName;
  private String lastName;
  private String birthPlace;
  private String birthDate;
  private String nationality;
  private String idNationality;
  private String idIssueDate;
  private String businessName;
  private String idType;
  private String idNumber;
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

  public String getBirthPlace() {
    return birthPlace;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public String getNationality() {
    return nationality;
  }

  public String getIdNationality() {
    return idNationality;
  }

  public String getIdIssueDate() {
    return idIssueDate;
  }

  public String getBusinessName() {
    return businessName;
  }

  public String getIdType() {
    return idType;
  }

  public String getIdNumber() {
    return idNumber;
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

  public String getValidationStatus() {
    return validationStatus;
  }

  public String getVerificationStatus() {
    return verificationStatus;
  }

  public String getSubaccount() {
    return subaccount;
  }

  public String getUrl() {
    return url;
  }

  public static IdentityCreator creator(String countryIso, String salutation, String firstName, String lastName,
                                        String birthPlace, String birthDate, String nationality, String idNationality,
                                        String idIssueDate, String businessName, String idType, String idNumber,
                                        String addressLine1, String addressLine2, String city, String region, String postalCode) {
    return new IdentityCreator(countryIso, salutation, firstName, lastName, birthPlace, birthDate,
      nationality, idNationality, idIssueDate, businessName, idType, idNumber, addressLine1, addressLine2,
      city, region, postalCode);
  }

  public static IdentityUpdater updater(String id){
    return new IdentityUpdater(id);
  }

  public static IdentityDeleter deleter(String id){
    return new IdentityDeleter(id);
  }

  public static IdentityGetter getter(String id){
    return new IdentityGetter(id);
  }

  public static IdentityLister lister(){
    return new IdentityLister();
  }

  @Override
  public String getId() {
    return id;
  }
}
