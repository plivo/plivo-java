package com.plivo.api.models.brand;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandUsecase extends BaseResource {  
  private List<Object> useCases;
  private String brandID;

  public static BrandUseCaseGetter getter(String id) {
    return new BrandUseCaseGetter(id);
  }

  /**
     * @return String return the UseCases
     */
    public List<Object> getUsecases() {
      return useCases;
  }

   @Override
  public String getId() {
    return this.brandID;
  }


}