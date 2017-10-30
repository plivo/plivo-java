package com.plivo.api.models.number;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class PhoneNumberCreateResponse extends BaseResponse {

  private String status;
  private List<PhoneNumberCreationStatus> numbers;

  public String getStatus() {
    return status;
  }

  public List<PhoneNumberCreationStatus> getNumbers() {
    return numbers;
  }
}
