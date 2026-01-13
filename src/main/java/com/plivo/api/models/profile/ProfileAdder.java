package com.plivo.api.models.profile;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class ProfileAdder extends Creator<ProfileAddResponse> {
    private String originator;
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
    private String altBusinessID;
    private String altBusinessIdType;
    private String plivoSubaccount;
    private ProfileAuthorizedContact authorizedContact;
    private String businessContactEmail;

    ProfileAdder(String profileAlias,String customerType,String entityType,String companyName,String ein,String einIssuingCountry,ProfileAddress address,String stockSymbol,String stockExchange,String website,String vertical,String altBusinessID,String altBusinessIdType,String plivoSubaccount,ProfileAuthorizedContact authorizedContact,String businessContactEmail) {
        this.profileAlias = profileAlias;
        this.customerType = customerType;
        this.entityType = entityType;
        this.companyName = companyName;
        this.ein = ein;
        this.einIssuingCountry = einIssuingCountry;
        this.address = address;
        this.stockSymbol = stockSymbol;
        this.stockExchange = stockExchange;
        this.website = website;
        this.vertical = vertical;
        this.altBusinessID = altBusinessID;
        this.altBusinessIdType = altBusinessIdType;
        this.plivoSubaccount = plivoSubaccount;
        this.authorizedContact = authorizedContact;
        this.businessContactEmail = businessContactEmail;
    }
    public String profileAlias(){
        return this.profileAlias;
    }
    public String customerType(){
        return this.customerType;
    }
    public String entityType(){
        return this.entityType;
    }
    public String companyName(){
        return this.companyName;
    }
    public String ein(){
        return this.ein;
    }
    public String einIssuingCountry(){
        return this.einIssuingCountry;
    }
    public ProfileAddress address(){
        return this.address;
    }
    public String stockSymbol(){
        return this.stockSymbol;
    }
    public String stockExchange(){
        return this.stockExchange;
    }
    public String website(){
        return this.website;
    }
    public String vertical(){
        return this.vertical;
    }
    public String altBusinessID(){
        return this.altBusinessID;
    }
    public String altBusinessIdType(){
        return this.altBusinessIdType;
    }
    public String plivoSubaccount(){
        return this.plivoSubaccount;
    }
    public ProfileAuthorizedContact authorizedContact(){
        return this.authorizedContact;
    }
    public String businessContactEmail(){
        return this.businessContactEmail;
    }

    @Override
    protected Call<ProfileAddResponse> obtainCall() {
      return client().getApiService().profileAdd(client().getAuthId(), this);
    }
}