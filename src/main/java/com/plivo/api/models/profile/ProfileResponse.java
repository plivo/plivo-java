package com.plivo.api.models.profile;

import com.plivo.api.models.base.BaseResponse;

public class ProfileResponse extends BaseResponse{
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
    private AuthorizedContact authorizedContact;
    private String primaryProfile;
    private String profileType;
    private String profileUUID;

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

    public AuthorizedContact getAuthorizedContact(){
        return authorizedContact;
    }

    public String getPrimaryProfile(){
        return primaryProfile;
    }

    public String getProfileType(){
        return profileType;
    }

    public String getProfileUUID(){
        return ProfileUUID;
    }

}