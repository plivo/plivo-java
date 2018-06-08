package com.plivo.api.models.identity;

import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public class IdentityCreator extends Creator<IdentityCreateResponse> {

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
  private String subaccount;
  private String file;

  public IdentityCreator(String countryIso, String salutation, String firstName, String lastName,
                         String birthPlace, String birthDate, String nationality, String idNationality,
                         String idIssueDate, String businessName, String idType, String idNumber,
                         String addressLine1, String addressLine2, String city, String region, String postalCode ){
    this.countryIso = countryIso;
    this.salutation = salutation;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthPlace = birthPlace;
    this.birthDate = birthDate;
    this.nationality = nationality;
    this.idNationality = idNationality;
    this.idIssueDate = idIssueDate;
    this.businessName = businessName;
    this.idType = idType;
    this.idNumber = idNumber;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.city = city;
    this.region = region;
    this.postalCode = postalCode;
  }

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

  public String birthPlace() {
    return birthPlace;
  }

  public String birthDate() {
    return birthDate;
  }

  public String nationality() {
    return nationality;
  }

  public String idNationality() {
    return idNationality;
  }

  public String idIssueDate() {
    return idIssueDate;
  }

  public String businessName() {
    return businessName;
  }

  public String idType() {
    return idType;
  }

  public String idNumber() {
    return idNumber;
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

  public String fiscalIdentificationCode() {
    return fiscalIdentificationCode;
  }

  public String streetCode() {
    return streetCode;
  }

  public String municipalCode() {
    return municipalCode;
  }

  public String subaccount() {
    return subaccount;
  }

  public String file() {
    return file;
  }

  public IdentityCreator alias( String alias ){
    this.alias = alias;
    return this;
  }

  public IdentityCreator countryIso( String countryIso ){
    this.countryIso = countryIso;
    return this;
  }

  public IdentityCreator salutation( String salutation ){
    this.salutation = salutation;
    return this;
  }

  public IdentityCreator firstName( String firstName ){
    this.firstName = firstName;
    return this;
  }

  public IdentityCreator lastName( String lastName ){
    this.lastName = lastName;
    return this;
  }

  public IdentityCreator birthPlace( String birthPlace ){
    this.birthPlace = birthPlace;
    return this;
  }

  public IdentityCreator birthDate( String birthDate ){
    this.birthDate = birthDate;
    return this;
  }

  public IdentityCreator nationality( String nationality ){
    this.nationality = nationality;
    return this;
  }

  public IdentityCreator idNationality( String idNationality ){
    this.idNationality = idNationality;
    return this;
  }

  public IdentityCreator idIssueDate( String idIssueDate ){
    this.idIssueDate = idIssueDate;
    return this;
  }

  public IdentityCreator businessName( String businessName ){
    this.businessName = businessName;
    return this;
  }

  public IdentityCreator idType( String idType ){
    this.idType = idType;
    return this;
  }

  public IdentityCreator idNumber( String idNumber ){
    this.idNumber = idNumber;
    return this;
  }

  public IdentityCreator addressLine1( String addressLine1 ){
    this.addressLine1 = addressLine1;
    return this;
  }

  public IdentityCreator addressLine2( String addressLine2 ){
    this.addressLine2 = addressLine2;
    return this;
  }

  public IdentityCreator city( String city ){
    this.city = city;
    return this;
  }

  public IdentityCreator region( String region ){
    this.region = region;
    return this;
  }

  public IdentityCreator postalCode( String postalCode ){
    this.postalCode = postalCode;
    return this;
  }

  public IdentityCreator fiscalIdentificationCode( String fiscalIdentificationCode ){
    this.fiscalIdentificationCode = fiscalIdentificationCode;
    return this;
  }

  public IdentityCreator streetCode( String streetCode ){
    this.streetCode = streetCode;
    return this;
  }

  public IdentityCreator municipalCode( String municipalCode ){
    this.municipalCode = municipalCode;
    return this;
  }

  public IdentityCreator subaccount( String subaccount ){
    this.subaccount = subaccount;
    return this;
  }

  public IdentityCreator file( String file ){
    this.file = file;
    return this;
  }

  @Override
  protected Call<IdentityCreateResponse> obtainCall() {
    return client().getApiService().identityCreate(client().getAuthId(), this);
  }
}
