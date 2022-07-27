package com.plivo.api.models.profile;

public class ProfileAddress {
  private String street;
  private String city;
  private String state;
  private String postalCode;
  private String country;

  public ProfileAddress(String street, String city, String state, String postalCode, String country) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
  }

  public ProfileAddress() {
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getPostalCode(){
    return postalCode;
  }

  public String getCountry() {
    return country;
  }
}