package com.plivo.api.models.brand;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandUsecase extends BaseResource {  
  private UseCases useCases;
  private BrandID brandID;

  public static BrandUsecaseGetter getter(String id) {
    return new BrandUsecaseGetter(id);
  }

  /**
     * @return String return the UseCases
     */
    public String getUsecases() {
      return useCases;
  }

   @Override
  public String getId() {
    return this.brandID;
  }


}