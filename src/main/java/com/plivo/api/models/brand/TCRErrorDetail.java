package com.plivo.api.models.brand;

public class TCRErrorDetail {
  private String code;
  private String message;

  public TCRErrorDetail(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public TCRErrorDetail() {
  }

  public String getCode() {
    return code;
  }
  public String getMessage(){
    return message;
  }
}