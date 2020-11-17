package com.plivo.api.models.compliancedocument;

import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComplianceDocumentCreator extends Creator<ComplianceDocumentCreateResponse> {

    private String endUserId;
    private String alias;
    private String documentTypeId;
    private String file;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String postalCode;
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String uniqueIdentificationNumber;
    private String businessName;
    private String authorizedRepresentativeName;
    private String nationality;
    private enum typeOfUtility {
        water,electricity,gas, propertyRental, others
      };
    private String billId;
    private String typeOfId;
    private String placeOfBirth;
    private String dateOfIssue;
    private String dateOfExpiration;
    private String billDate;
    private String supportEmail;
    private String supportPhoneNumber;
    private String useCaseDescription;
    private MultipartBody.Builder body;

  ComplianceDocumentCreator(String endUserId, String documentTypeId, String alias) {
        if (!Utils.allNotNull(alias, endUserId)) {
            throw new IllegalArgumentException("alias, endUserId must not be null");
        }

        this.alias = alias;
        this.endUserId = endUserId;
        this.documentTypeId = documentTypeId;
        this.body = new MultipartBody.Builder().setType(MultipartBody.FORM);
        this.body.addFormDataPart("alias", alias);
        this.body.addFormDataPart("end_user_id", endUserId);
        this.body.addFormDataPart("document_type_id", documentTypeId);
  }

  public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
    this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    this.body.addFormDataPart("unique_identification_number", uniqueIdentificationNumber);
  }

  public void setTypeOfId(String typeOfId) {
    this.typeOfId = typeOfId;
    this.body.addFormDataPart("type_of_id", typeOfId);
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
    this.body.addFormDataPart("business_name", businessName);
  }

  public void setAuthorizedRepresentativeName(String authorizedRepresentativeName) {
    this.authorizedRepresentativeName = authorizedRepresentativeName;
    this.body.addFormDataPart("authorized_representative_name", authorizedRepresentativeName);
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
    this.body.addFormDataPart("nationality", nationality);
  }

  public void setBillId(String billId) {
    this.billId = billId;
    this.body.addFormDataPart("bill_id", billId);
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
    this.body.addFormDataPart("place_of_birth", placeOfBirth);
  }

  public void setDateOfIssue(String dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
    this.body.addFormDataPart("date_of_issue", dateOfIssue);
  }

  public void setDateOfExpiration(String dateOfExpiration) {
    this.dateOfExpiration = dateOfExpiration;
    this.body.addFormDataPart("date_of_expiration", dateOfExpiration);
  }

  public void setBillDate(String billDate) {
    this.billDate = billDate;
    this.body.addFormDataPart("bill_date", billDate);
  }

  public void setSupportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
    this.body.addFormDataPart("support_email", supportEmail);
  }

  public void setSupportPhoneNumber(String supportPhoneNumber) {
    this.supportPhoneNumber = supportPhoneNumber;
    this.body.addFormDataPart("support_phone_number", supportPhoneNumber);
  }

  public void setUseCaseDescription(String useCaseDescription) {
    this.useCaseDescription = useCaseDescription;
    this.body.addFormDataPart("use_case_description", useCaseDescription);
  }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
      this.body.addFormDataPart("address_line_1", addressLine1);
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
      this.body.addFormDataPart("address_line_2", addressLine2);
    }

    public void setAlias(String alias) {
        this.alias = alias;
        this.body.addFormDataPart("alias", alias);
    }

    public void setCity(String city) {
        this.city = city;
      this.body.addFormDataPart("city", city);
    }

    public void setCountry(String country) {
        this.country = country;
      this.body.addFormDataPart("country", country);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
      this.body.addFormDataPart("date_of_birth", dateOfBirth);
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
        this.body.addFormDataPart("document_type_id", documentTypeId);
    }

    public void setEndUserId(String endUserId) {
        this.endUserId = endUserId;
        this.body.addFormDataPart("end_user_id", endUserId);
    }

    public void setFile(String file) throws ResourceNotFoundException {
        this.file = file;
        File tempFile = new File(file);
        boolean exists = tempFile.exists();
        if (!exists)
          throw new ResourceNotFoundException("File missing " + file);
        try {
          System.out.println(tempFile);
          System.out.println(tempFile.toPath());
          // handle for java 8
          String content_type = "";
          if (Files.probeContentType(tempFile.toPath()) != null) {
            content_type = Files.probeContentType(tempFile.toPath());
          } else {
            Path source = Paths.get(file);
            MimetypesFileTypeMap m = new MimetypesFileTypeMap(source.toString());
            content_type = m.getContentType(tempFile);
          }
          this.body
            .addFormDataPart("file", file,
              RequestBody.create(MediaType.parse(content_type), tempFile));
        } catch (IOException e) {
          throw new ResourceNotFoundException("Unable to read file " + file);
        }
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
      this.body.addFormDataPart("first_name", firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
      this.body.addFormDataPart("last_name", lastName);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
      this.body.addFormDataPart("postal_code", postalCode);
    }


    @Override
    protected Call<ComplianceDocumentCreateResponse> obtainCall() {
      return client().getApiService().complianceDocumentCreate( client().getAuthId(), this.body.build());
    }
}
