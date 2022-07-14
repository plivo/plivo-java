package com.plivo.api.models.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Profile extends BaseResource {

  private String profileUUID;
  private ProfileResponse profile;
  private List<ProfileResponse> profiles;

  public List<ProfileResponse> getProfiles() {
    return profiles;
  }
  
  public static  ProfileAdder creator(String originator,String profileAlias,String customerType,String entityType,String companyName,String ein,String einIssuingCountry,Address address,String stockSymbol,String stockExchange,String website,String vertical,String altBusinessID,String altBusinessIdType,String plivoSubaccount,AuthorizedContact authorizedContact) {
    return new ProfileAdder(originator,profileAlias,customerType,entityType,companyName,ein,einIssuingCountry,address,stockSymbol,stockExchange,website,vertical,altBusinessID,altBusinessIdType,plivoSubaccount,authorizedContact);
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

  @Override
  public String getProfileUUID() {
    return this.profileUUID;
  }

}