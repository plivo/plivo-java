package com.plivo.api.models.brand;

public class BrandResponse extends BaseResponse {

    private String altBusinessIDType;
	private String altBusinessID; 
	private String city;               
	private String companyName;      
    private String country;           
	private String ein;             
	private String einIssuingCountry;
	private String email;              
	private String entityType;         
	private String firstName;         
	private String lastName;          
	private String phone;       
	private String postalCode;
	private String registrationStatus;
	private String state;
	private String stockExchange;       
	private String stockSymbol;        
	private String street;            
	private String vertical;      
	private String website;   
	private String secondaryVetting;

  public BrandResponse() {
  }
  /**
     * @return String return the altBusinessIDType
     */
    public String getAltBusinessIDType() {
        return altBusinessIDType;
    }

    /**
     * @return String return the altBusinessID
     */
    public String getAltBusinessID() {
        return altBusinessID;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }


    /**
     * @return String return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }


    /**
     * @return String return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return String return the ein
     */
    public String getEin() {
        return ein;
    }


    /**
     * @return String return the einIssuingCountry
     */
    public String getEinIssuingCountry() {
        return einIssuingCountry;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return String return the entityType
     */
    public String getEntityType() {
        return entityType;
    }


    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return String return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return String return the registrationStatus
     */
    public String getRegistrationStatus() {
        return registrationStatus;
    }


    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }


    /**
     * @return String return the stockExchange
     */
    public String getStockExchange() {
        return stockExchange;
    }


    /**
     * @return String return the stockSymbol
     */
    public String getStockSymbol() {
        return stockSymbol;
    }


    /**
     * @return String return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return String return the vertical
     */
    public String getVertical() {
        return vertical;
    }

    /**
     * @return String return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @return String return the secondaryVetting
     */
    public String getSecondaryVetting() {
        return secondaryVetting;
    }


  
}
