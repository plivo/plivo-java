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

  /**
     * @return String return the getBrandID
     */
    public String getBrandID() {
        return brandID;
    }

    /**
     * @return String return the getBrandType
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * @return String return the geteinIssuingCountry
     */
    public String geteinIssuingCountry() {
        return einIssuingCountry;
    }


    /**
     * @return String return the getEntityType
     */
    public String getEntityType() {
        return entityType;
    }


    /**
     * @return String return the getProfileUUID
     */
    public String getProfileUUID() {
        return profileUUID;
    }

    /**
     * @return String return the getRegistrationStatus
     */
    public String getRegistrationStatus() {
        return registrationStatus;
    }


    /**
     * @return String return the getVertical
     */
    public String getVertical() {
        return vertical;
    }

    /**
     * @return String return the getAddress
     */
    public Address  getAddress() {
        return address;
    }

    /**
     * @return String return the getAuthorizedContact
     */
    public AuthorizedContact getAuthorizedContact() {
        return authorizedContact;
    }
  
}
