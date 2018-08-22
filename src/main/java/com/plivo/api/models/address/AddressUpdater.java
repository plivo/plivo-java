package com.plivo.api.models.address;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class AddressUpdater extends Updater<AddressUpdateResponse> {

  private String countryIso;
  private String salutation;
  private String firstName;
  private String lastName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String region;
  private String postalCode;

  public AddressUpdater(String id) {
    super(id);
  }

  public String getCountryIso() {
    return countryIso;
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

  public AddressUpdater countryIso(String countryIso) {
    this.countryIso = countryIso;
    return this;
  }

  public AddressUpdater salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  public AddressUpdater firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AddressUpdater lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public AddressUpdater addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public AddressUpdater addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public AddressUpdater city(String city) {
    this.city = city;
    return this;
  }

  public AddressUpdater region(String region) {
    this.region = region;
    return this;
  }

  public AddressUpdater postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  @Override
  protected Call<AddressUpdateResponse> obtainCall() {
    return client().getApiService().addressUpdate(client().getAuthId(), id, this);
  }
}
