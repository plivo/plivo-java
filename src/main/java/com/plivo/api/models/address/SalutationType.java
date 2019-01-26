package com.plivo.api.models.address;

public enum SalutationType {
	  MR("Mr"),
	  MRS("Mrs");

	  private final String salutation;

	  SalutationType(final String salutation) {
	    this.salutation = salutation;
	  }

	  @Override
	  public String toString() {
	    return this.salutation;
	  }
}
