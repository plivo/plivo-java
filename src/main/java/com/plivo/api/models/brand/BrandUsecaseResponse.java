package com.plivo.api.models.brand;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandUsecaseResponse extends BaseResponse {

    private List<Object> useCases;
    private String brandID;

    /**
     * @return String return the getBrandID
     */
    public String getBrandID() {
        return brandID;
    }

    /**
     * @return String return the getBrandType
     */
    public List<Object> getBrandUsecases() {
        return useCases;
    }

    @Override                                      
    public String getId() {                        
        return this.brandID;                    
    }
  
}
