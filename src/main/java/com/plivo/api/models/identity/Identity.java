package com.plivo.api.models.identity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

import java.time.LocalDate;

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

  public static IdentityCreator creator(String countryIso, String salutation, String firstName, String lastName,
                                        String birthPlace, LocalDate birthDate, String nationality, String idNationality,
                                        LocalDate idIssueDate, String businessName, String idType, String idNumber,
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

  /**
   * @return Country ISO 2 code.
   */
  public String getCountryIso() {
    return countryIso;
  }

  /**
   * @return Alias name of the address.
   */
  public String getAlias() {
    return alias;
  }

  public String getSalutation() {
    return salutation;
  }

  /**
   * @return First name of the user for whom the identity is created.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return Last name of the user for whom the identity is created.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return Birthplace of the user for whom the identity is created.
   */
  public String getBirthPlace() {
    return birthPlace;
  }

  /**
   * @return Birth date in yyyy-mm-dd format of the user for whom the identity is created.
   */
  public String getBirthDate() {
    return birthDate;
  }

  /**
   * @return Nationality of the user for whom the identity is created.
   */
  public String getNationality() {
    return nationality;
  }

  /**
   * @return Nationality mentioned in the identity proof.
   */
  public String getIdNationality() {
    return idNationality;
  }

  /**
   * @return Issue date in yyyy-mm-dd mentioned in the identity proof.
   */
  public String getIdIssueDate() {
    return idIssueDate;
  }

  /**
   * @return Business name of the user for whom the identity is created.
   */
  public String getBusinessName() {
    return businessName;
  }

  /**
   * @return Building name/number
   */
  public String getIdType() {
    return idType;
  }

  /**
   * @return The unique number on the identifier.
   */
  public String getIdNumber() {
    return idNumber;
  }

  /**
   * @return Building name/number
   */
  public String getAddressLine1() {
    return addressLine1;
  }

  /**
   * @return The street name/number of the address
   */
  public String getAddressLine2() {
    return addressLine2;
  }

  /**
   * @return The city of the address for which the address proof is created
   */
  public String getCity() {
    return city;
  }

  /**
   * @return The region of the address for which the address proof is created
   */
  public String getRegion() {
    return region;
  }

  /**
   * @return The postal code of the address that is being created
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * @return The code is available for businesses alone and will be available for spain mobile numbers.
   *         If not present, return null
   */
  public String getFiscalIdentificationCode() {
    return fiscalIdentificationCode;
  }

  /**
    * @return Street code of the address. Return null if not present.
   */
  public String getStreetCode() {
    return streetCode;
  }

  /**
   * @return Municipal code of the address. Return null if not present.
   */
  public String getMunicipalCode() {
    return municipalCode;
  }

  /**
   * @return Can take the following values: pending. accepted, rejected, null
   */
  public String getValidationStatus() {
    return validationStatus;
  }

  /**
   * @return Can take the following values: pending. verified, rejected
   */
  public String getVerificationStatus() {
    return verificationStatus;
  }

  /**
   * @return The link to the subaccount resource associated with the application.
   *         If the application belongs to the main account, this field will be null.
   */
  public String getSubaccount() {
    return subaccount;
  }

  /**
   * @return A plivo wrapped link to the document stored in the Plivo CDN.
   */
  public String getUrl() {
    return url;
  }

  @Override
  public String getId() {
    return id;
  }
}
