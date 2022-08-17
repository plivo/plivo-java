package com.plivo.api.models.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Profile extends BaseResource {

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
  private ProfileResponse profile;
  
  public static  ProfileAdder creator(String profileAlias,String customerType,String entityType,String companyName,String ein,String einIssuingCountry,ProfileAddress address,String stockSymbol,String stockExchange,String website,String vertical,String altBusinessID,String altBusinessIdType,String plivoSubaccount,AuthorizedContact authorizedContact) {
    return new ProfileAdder(profileAlias,customerType,entityType,companyName,ein,einIssuingCountry,address,stockSymbol,stockExchange,website,vertical,altBusinessID,altBusinessIdType,plivoSubaccount,authorizedContact);
  }

  public static ProfileGetter getter(String id) {
    return new ProfileGetter(id);
  }

  public static ProfileLister lister() {
    return new ProfileLister();
  }

  public ProfileResponse getProfile(){
      return this.profile;
  }
  
  public String getProfileUUID() {
    return this.profileUUID;
  }

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

 @Override
  public String getId() {
    return getProfileUUID();
  }

}