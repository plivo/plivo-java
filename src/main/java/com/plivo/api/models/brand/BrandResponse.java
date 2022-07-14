package com.plivo.api.models.brand;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;
public class BrandResponse extends BaseResponse {

        private String brandID;
        private String brandType;
        private String einIssuingCountry;
        private String  entityType;
        private String  profileUUID;
        private String  registrationStatus;
        private String  vertical;
        private Address address;
        private AuthorizedContact authorizedContact;

  public BrandResponse() {
  }
  /**
     * @return String return the altBusinessIDType
     */
    public String getBrandID() {
        return brandID;
    }

    /**
     * @return String return the altBusinessID
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * @return String return the city
     */
    public String geteInIssuingCountry() {
        return einIssuingCountry;
    }


    /**
     * @return String return the companyName
     */
    public String getEntityType() {
        return entityType;
    }


    /**
     * @return String return the country
     */
    public String getProfileUUID() {
        return profileUUID;
    }

    /**
     * @return String return the ein
     */
    public String getRegistrationStatus() {
        return registrationStatus;
    }


    /**
     * @return String return the einIssuingCountry
     */
    public String getVertical() {
        return vertical;
    }

    /**
     * @return String return the email
     */
    public Address  getAddress() {
        return address;
    }

    /**
     * @return String return the entityType
     */
    public AuthorizedContact getAuthorizedContact() {
        return authorizedContact;
    }
  
}
