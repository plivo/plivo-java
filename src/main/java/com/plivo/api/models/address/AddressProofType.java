package com.plivo.api.models.address;

public enum AddressProofType {

  NATIONAL_ID("national_id"),
  PASSPORT("passport"),
  BUSINESS_ID("business_id"),
  NIF("nif"),
  NIE("nie"),
  DNI("dni"),
  ANY("any");

  private final String addressProofType;

  AddressProofType(String addressProofType){
    this.addressProofType = addressProofType;
  }

  @Override
  public String toString() {
    return addressProofType;
  }
}
