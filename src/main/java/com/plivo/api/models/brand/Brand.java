package com.plivo.api.models.brand;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand extends BaseResource {  
  private String brandID;
  private String brandAlias;
  private String brandType;
  private String einIssuingCountry;
  private String  entityType;
  private String  profileUUID;
  private String  registrationStatus;
  private String  vertical;
  private Address address;
  private AuthorizedContact authorizedContact;
  private BrandResponse brand;
  private String createdAt;
  private List<TCRErrorDetail> declinedReasons;

  public static BrandCreator creator(String brandAlias,String profileUUID,String brandType,Boolean secondaryVetting,String url,String method) {
    return new BrandCreator(brandAlias,profileUUID,brandType,secondaryVetting,url,method);
  }

  public static BrandGetter getter(String id) {
    return new BrandGetter(id);
  }

  public static BrandLister lister() {
    return new BrandLister();
  }

  public static BrandUseCaseGetter get_usecases(String id) {
    return new BrandUseCaseGetter(id);
  }

  public static BrandDeleter deleter(String id) {
    return new BrandDeleter(id);
  }

  /**
     * @return String return the getBrandAlias
     */
    public String getBrandAlias() {
      return brandAlias;
  }

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
  public String getEinIssuingCountry() {
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

    /**
   * @return String return the getCreatedAt
   */
  public String getCreatedAt() {
      return createdAt;
  }

   /**
   * @return TCRErrorDetail[] return the getDeclinedReasons
   */
  public List<TCRErrorDetail> getDeclinedReasons() {
      return declinedReasons;
  }  

  public BrandResponse getBrand() {
    return brand;                               
  }
   
   @Override
  public String getId() {
    return this.brandID;
  }

}
