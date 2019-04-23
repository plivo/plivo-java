package com.plivo.api.models.address;

import java.io.File;

import com.plivo.api.models.base.Updater;
import com.plivo.api.util.Utils;

import retrofit2.Call;

public class AddressUpdater extends Updater<AddressUpdateResponse> {

  private String countryIso;
  private String salutation;
  private String firstName;
  private String lastName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String region;
  private String postalCode;
  private String callbackUrl;
  private Boolean autoCorrectAddress;
  private String idNumber;
  private String phoneNumberCountry;
  private String numberType;
  private File file;
  private String fiscalIdentificationCode;
  private String streetCode;
  private String municipalCode;
  private String alias;
  private String addressProofType;
  private String callBackUrl;

  public AddressUpdater(String id) {
    super(id);
  }

  public String getCountryIso() {
    return countryIso;
  }

  public String getCallbackUrl() {
		return callbackUrl;
	}

	public Boolean getAutoCorrectAddress() {
		return autoCorrectAddress;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getPhoneNumberCountry() {
		return phoneNumberCountry;
	}

	public String getNumberType() {
		return numberType;
	}

	public File getFile() {
		return file;
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

	public String getAlias() {
		return alias;
	}

	public String getAddressProofType() {
		return addressProofType;
	}

	public String getCallBackUrl() {
		return callBackUrl;
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

  public AddressUpdater countryIso(String countryIso) {
    this.countryIso = countryIso;
    return this;
  }

  public AddressUpdater salutation(SalutationType salutation) {
    this.salutation = salutation.toString();
    return this;
  }

  public AddressUpdater firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AddressUpdater lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public AddressUpdater addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public AddressUpdater addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public AddressUpdater city(String city) {
    this.city = city;
    return this;
  }

  public AddressUpdater region(String region) {
    this.region = region;
    return this;
  }

  public AddressUpdater postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }
  
  public AddressUpdater file(String fileName) {
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
  
  public AddressUpdater autoCorrectAddress(Boolean autoCorrectAddress) {
		this.autoCorrectAddress = autoCorrectAddress;
		return this;
  }
  
  public AddressUpdater idNumber(String idNumber) {
		this.idNumber = idNumber;
		return this;
  }
  
  public AddressUpdater phoneNumberCountry(String phoneNumberCountry) {
		this.phoneNumberCountry = phoneNumberCountry;
		return this;
  }
  
  public AddressUpdater numberType(NumberType numberType) {
		this.numberType = numberType.toString();
		return this;
  }
  public AddressUpdater fiscalIdentificationCode(String fiscalIdentificationCode) {
		this.fiscalIdentificationCode = fiscalIdentificationCode;
		return this;
  }

  public AddressUpdater streetCode(String streetCode) {
		this.streetCode = streetCode;
		return this;
  }

  public AddressUpdater municipalCode(String municipalCode) {
		this.municipalCode = municipalCode;
		return this;
  }
  
  public AddressUpdater addressProofType(AddressProofType proofType) {
		this.addressProofType = proofType.toString();
		return this;
  }
  
  public AddressUpdater alias(String alias) {
		this.alias = alias;
		return this;
  }
  
  public AddressUpdater callBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
		return this;
  }
  
  @Override
  protected Call<AddressUpdateResponse> obtainCall() {
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
    return client().getApiService().addressUpdate(client().getAuthId(), id, this);
  }
}
