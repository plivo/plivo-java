package com.plivo.api.models.address;

public enum Salutation {
  MR("Mr"), MS("Ms");

  private final String salutation;

  Salutation(String salutation){
    this.salutation = salutation;
  }

  @Override
  public String toString() {
    return salutation;
  }
}
