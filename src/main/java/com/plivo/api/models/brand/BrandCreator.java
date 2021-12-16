


package com.plivo.api.models.brand;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class BrandCreator extends Creator<Brand> {
  private String altBusinessIDType;
  private String altBusinessID;
  private String city;
  private String companyName;
  private String country;
  private String ein;
  private String einIssuingCountry;
  private String email;
  private String entityType;
  private String firstName;
  private String lastName;
  private String phone;
  private String postalCode;
  private String registrationStatus;
  private String state;
  private String stockExchange;
  private String stockSymbol;
  private String street;
  private String vertical;
  private String website;
  private String secondaryVetting;

  
  BrandCreator(String altBusinessIDType,String altBusinessID, String city,String companyName,String country,String ein,String einIssuingCountry,String email,String entityType,String firstName,String lastName,String phone,String postalCode,String registrationStatus,String state,String stockExchange,String stockSymbol, String street, String vertical,String website,String secondaryVetting) {
   
    this.altBusinessIDType = altBusinessIDType;
    this.altBusinessID = altBusinessID;
    this.city = city;
    this.companyName = companyName;
    this.country = country;
    this.ein = ein;
    this.einIssuingCountry = einIssuingCountry;
    this.email = email;
    this.entityType = entityType;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.postalCode = postalCode;
    this.registrationStatus = registrationStatus;
    this.stockExchange = stockExchange;
    this.stockSymbol = stockSymbol;
    this.state = state;
    this.vertical = vertical;
    this.website = website;
    this.street = street;
    this.secondaryVetting = secondaryVetting;

  }

  public String altBusinessIDType() {
    return this.altBusinessIDType;
  }

  public String altBusinessID() {
    return this.altBusinessID;
  }

  public String city() {
    return this.city;
  }

  public String companyName() {
    return this.companyName;
  }

  public String country() {
    return this.country;
  }
  public String ein(){
      return this.ein;
  }
  public String einIssuingCountry(){
      return this.einIssuingCountry;
  }
  public String email(){
      return this.email;
  }
  public String entityType(){
      return this.entityType;
  }
  public String firstName(){
      return this.firstName;
  }
  public String lastName(){
      return this.lastName;
  }
  public String phone(){
      return this.phone;
  }
  public String postalCode(){
      return this.postalCode;
  }
  public String registrationStatus(){
      return this.registrationStatus;
  }
  public String stockExchange(){
      return this.stockExchange;
  }
  public String stockSymbol(){
      return this.stockSymbol;
  }
  public String state(){
      return this.state;
  }
  public String vertical(){
      return this.vertical;
  }
  public String website(){
      return this.website;
  }
  public String street(){
      return this.street;
  }
  public String secondaryVetting(){
      return this.secondaryVetting;
  }

  @Override
  protected Call<Brand> obtainCall() {
    return client().getApiService().createBrand(client().getAuthId(), this);
  }
}