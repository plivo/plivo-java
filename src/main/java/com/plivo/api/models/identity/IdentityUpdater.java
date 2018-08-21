package com.plivo.api.models.identity;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class IdentityUpdater extends Updater<IdentityUpdateResponse> {
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

  public IdentityUpdater( String id ){
    super(id);
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

  public IdentityUpdater alias( String alias ){
    this.alias = alias;
    return this;
  }

  public IdentityUpdater countryIso( String countryIso ){
    this.countryIso = countryIso;
    return this;
  }

  public IdentityUpdater salutation( String salutation ){
    this.salutation = salutation;
    return this;
  }

  public IdentityUpdater firstName( String firstName ){
    this.firstName = firstName;
    return this;
  }

  public IdentityUpdater lastName( String lastName ){
    this.lastName = lastName;
    return this;
  }

  public IdentityUpdater birthPlace( String birthPlace ){
    this.birthPlace = birthPlace;
    return this;
  }

  public IdentityUpdater birthDate( String birthDate ){
    this.birthDate = birthDate;
    return this;
  }

  public IdentityUpdater nationality( String nationality ){
    this.nationality = nationality;
    return this;
  }

  public IdentityUpdater idNationality( String idNationality ){
    this.idNationality = idNationality;
    return this;
  }

  public IdentityUpdater idIssueDate( String idIssueDate ){
    this.idIssueDate = idIssueDate;
    return this;
  }

  public IdentityUpdater businessName( String businessName ){
    this.businessName = businessName;
    return this;
  }

  public IdentityUpdater idType( String idType ){
    this.idType = idType;
    return this;
  }

  public IdentityUpdater idNumber( String idNumber ){
    this.idNumber = idNumber;
    return this;
  }

  public IdentityUpdater addressLine1( String addressLine1 ){
    this.addressLine1 = addressLine1;
    return this;
  }

  public IdentityUpdater addressLine2( String addressLine2 ){
    this.addressLine2 = addressLine2;
    return this;
  }

  public IdentityUpdater city( String city ){
    this.city = city;
    return this;
  }

  public IdentityUpdater region( String region ){
    this.region = region;
    return this;
  }

  public IdentityUpdater postalCode( String postalCode ){
    this.postalCode = postalCode;
    return this;
  }

  public IdentityUpdater fiscalIdentificationCode( String fiscalIdentificationCode ){
    this.fiscalIdentificationCode = fiscalIdentificationCode;
    return this;
  }

  public IdentityUpdater streetCode( String streetCode ){
    this.streetCode = streetCode;
    return this;
  }

  public IdentityUpdater municipalCode( String municipalCode ){
    this.municipalCode = municipalCode;
    return this;
  }

  public IdentityUpdater subaccount( String subaccount ){
    this.subaccount = subaccount;
    return this;
  }

  public IdentityUpdater file( String file ){
    this.file = file;
    return this;
  }

  @Override
  protected Call<IdentityUpdateResponse> obtainCall() {
    return client().getApiService().identityUpdate(client().getAuthId(), id, this);
  }
}
