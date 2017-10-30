package com.plivo.api.models.account;

public enum AccountType {
  STANDARD("standard"), DEVELOPER("developer");

  private String accountType;

  AccountType(String accountType) {
    this.accountType = accountType;
  }

  @Override
  public String toString() {
    return accountType;
  }
}
