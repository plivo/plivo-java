package com.plivo.api.models.campaign;

public class PhoneNumbers {
  private String number;
  private String status;

  public PhoneNumbers(String number, String status) {
    this.number = number;
    this.status = status;
  }

  public PhoneNumbers() {
  }

  public String getNumber() {
    return number;
  }

  public String getStatus() {
    return status;
  }

}