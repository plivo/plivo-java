package com.plivo.api.models.verify_session;

import java.util.List;

public class Charges {
  private String totalCharge;
  private String validationCharge;
  private List<AttemptCharge> attemptCharges;

  public Charges(String totalCharge, String validationCharge, List<AttemptCharge> attemptCharges) {
    this.totalCharge = totalCharge;
    this.validationCharge = validationCharge;
    this.attemptCharges = attemptCharges;
  }

  public Charges(){}
  public String getTotalCharge(){
    return totalCharge;
  }
  public String getValidationCharge(){
    return validationCharge;
  }
  public List<AttemptCharge> getAttemptCharges(){
    return attemptCharges;
  }
}
