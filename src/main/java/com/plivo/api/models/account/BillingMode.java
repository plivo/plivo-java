package com.plivo.api.models.account;

public enum BillingMode {
  PREPAID("prepaid"), POSTPAID("postpaid");

  private String billingMode;

  BillingMode(String billingMode) {
    this.billingMode = billingMode;
  }

  @Override
  public String toString() {
    return billingMode;
  }
}
