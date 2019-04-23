package com.plivo.api.models.address;

import java.io.File;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class AddressCreator extends Creator<AddressCreateResponse> {

  private String countryIso;
  private String alias;
  private String salutation;
  private String firstName;
  private String lastName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String region;
  private String postalCode;
  private File file;
  private Boolean autoCorrectAddress;
  private String addressProofType;
  private String phoneNumberCountry;
  private String fiscalIdentificationCode;
  private String streetCode;
  private String municipalCode;
  private String numberType;
  private String idNumber;
  private String callBackUrl;


	public String getCountryIso() {
		return countryIso;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public String getSalutation() {
		return salutation;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public File getFile() {
		return file;
	}
	
	public Boolean getAutoCorrectAddress() {
		return autoCorrectAddress;
	}
	
	public String getAddressProofType() {
		return addressProofType;
	}
	
	public String getPhoneNumberCountry() {
		return phoneNumberCountry;
	}
	
	public String getFiscalIdentificationCode() {
		return fiscalIdentificationCode;
	}
	
	public String getStreetCode() {
		return streetCode;
	}
	
	public String getMunicipalCode() {
		return municipalCode;
	}
	
	public String getNumberType() {
		return numberType;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	
	public String getCallBackUrl() {
		return callBackUrl;
	}

  public AddressCreator(String phoneNumberCountry, NumberType numberType, SalutationType salutation, String firstName, String lastName,
		String addressLine1, String addressLine2, String city, String region, String postalCode, String countryIso) {
	
		if (!Utils.allNotNull(phoneNumberCountry, numberType, salutation, firstName, lastName,
				addressLine1, addressLine2, city, region, postalCode, countryIso)) {
			throw new IllegalArgumentException("phoneNumberCountry, numberType, salutation, firstName, lastName," +
					"addressLine1, addressLine2, city, region, postalCode and countryIso must not be null");
		}
	
		this.phoneNumberCountry = phoneNumberCountry;
		this.numberType = numberType.toString();
		this.salutation = salutation.toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.countryIso = countryIso;
	
  }

  public AddressCreator callbackUrl(String callbackUrl) {
	this.callBackUrl = callbackUrl;
	return this;
  }
  
  public AddressCreator alias(String alias) {
    this.alias = alias;
    return this;
  }

  public AddressCreator file(String fileName) {
		File file = null;
		if(!Utils.isValidExtension(fileName)) {
			throw new IllegalArgumentException("File that are supported are png,jpg and pdf");
		}
		file = new File(fileName);
		if(!file.exists()) {
			throw new IllegalArgumentException("File not found in the specified path");
		}
		if(!Utils.isValidSize(file)) {
			throw new IllegalArgumentException("File size exceeds 5 MB");
		}
	
		this.file = file;
		return this;
  }

  public AddressCreator autoCorrectAddress(Boolean autoCorrectAddress) {
    this.autoCorrectAddress = autoCorrectAddress;
    return this;
  }

  public AddressCreator addressProofType(AddressProofType addressProofType) {
    this.addressProofType = addressProofType.toString();
    return this;
  }
  
  public AddressCreator fiscalIdentificationCode(String fiscalIdentificationCode) {
		this.fiscalIdentificationCode = fiscalIdentificationCode;
		return this;
  }
  
  public AddressCreator streetCode(String streetCode) {
		this.streetCode = streetCode;
		return this;
  }

	 public AddressCreator municipalCode(String municipalCode) {
		 this.municipalCode = municipalCode;
		 return this;
	 }
	 
	 public AddressCreator idNumber(String idNumber) {
	   this.idNumber = idNumber;
	   return this;
	 }
	
 @Override
 protected Call<AddressCreateResponse> obtainCall() {
	 if(this.countryIso != null && this.countryIso.equals("ES")) {
		  if(this.fiscalIdentificationCode == null) {
		  	throw new IllegalArgumentException("The parameter fiscal_identification_code is required for Spain numbers");
		  }
 	 }

	 if(this.countryIso != null && this.countryIso.equals("DK")) {
		 	if(this.streetCode == null || this.municipalCode == null) {
		 		throw new IllegalArgumentException("The parameters street_code and municipal_code are required for Denmark numbers");
		 	}
	 }
	 
	 return client().getApiService().addressCreate(client().getAuthId(), this);
  }
  
}


