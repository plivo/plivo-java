package com.plivo.api.models.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseResource {

  private String id;
  private String countryIso;
  private String alias;
  private Salutation salutation;
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
    String countryIso, Salutation salutation, String firstName, String lastName,
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

  public Salutation getSalutation() {
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
   * @return Building name/number.
   */
  public String getAddressLine1() {
    return addressLine1;
  }

  /**
   * @return The street name/number of the address.
   */
  public String getAddressLine2() {
    return addressLine2;
  }

  /**
   * @return The city of the address for which the address proof is created.
   */
  public String getCity() {
    return city;
  }

  /**
   * @return The region of the address for which the address proof is created.
   */
  public String getRegion() {
    return region;
  }

  /**
   * @return The postal code of the address that is being created.
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * @return The code is available for businesses alone and will be available for spain mobile numbers.
   *         If not present, return null.
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
   * @return Can take the following values: pending. accepted, rejected, null.
   */
  public String getValidationStatus() {
    return validationStatus; }

  /**
   * @return Can take the following values: pending. verified, rejected, null.
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

  /**
   * @return The type of document that is provided as address proof.
   */
  public AddressProofType getAddressProofType() {
    return addressProofType;
  }

  @Override
  public String getId() {
    return id;
  }
}
