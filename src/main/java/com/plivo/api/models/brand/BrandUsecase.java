package com.plivo.api.models.brand;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import com.plivo.api.models.base.BaseResponse;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandUsecase extends BaseResource {  
  private List<Object> useCases = new ArrayList<Object>();
  private String brandId;
  private BrandUsecaseResponse brandUsecase;

  public static BrandUseCaseGetter getter(String id) {
    return new BrandUseCaseGetter(id);
  }

  /**
   * @return String return the UseCases
  */
  public List<Object> getUsecases() {
    return useCases;
  }
  
  public BrandUsecaseResponse getBrandUsecases() {
    return brandUsecase;                               
  }

  /**
   * @return String return the brandId
   */
  public String getbrandId() {
    return brandId;
}

  @Override
  public String getId() {
    return this.brandId;
  }

}