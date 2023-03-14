package com.plivo.api.models.profile;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileResponse extends BaseResource{
    private String profileAlias;
    private String customerType;
    private String entityType;
    private String companyName;
    private String ein;
    private String einIssuingCountry;
    private ProfileAddress address;
    private String stockSymbol;
    private String stockExchange;
    private String website;
    private String vertical;
    private String altBusinessIdType;
    private String plivoSubaccount;
    private ProfileAuthorizedContact authorizedContact;
    private String primaryProfile;
    private String profileType;
    private String profileUUID;
    private String createdAt;

     public String getProfileAlias(){
        return profileAlias;
    }

    public String getCustomerType(){
        return customerType;
    }

    public String getEntityType(){
        return entityType;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getEin(){
        return ein;
    }

    public String getEinIssuingCountry(){
        return einIssuingCountry;
    }

    public ProfileAddress getAddress(){
        return address;
    }

    public String getStockSymbol(){
        return stockSymbol;
    }

    public String getStockExchange(){
        return stockExchange;
    }

    public String getwebsite(){
        return website;
    }

    public String getVertical(){
        return vertical;
    }

    public String getAltBusinessIdType(){
        return altBusinessIdType;
    }

    public String getPlivoSubaccount(){                                                                                                                                                                         
        return plivoSubaccount;                                                                                                                                                                                   
    }

    public ProfileAuthorizedContact getAuthorizedContact(){
        return authorizedContact;
    }

    public String getPrimaryProfile(){
        return primaryProfile;
    }

    public String getProfileType(){
        return profileType;
    }

    public String getProfileUUID(){
        return profileUUID;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    @Override
    public String getId() {
        return this.profileUUID;
    }

}