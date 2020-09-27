package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.BaseResponse;

public class ComplianceDocumentCreateResponse extends BaseResponse {
    private String endUserId;
    private String createdAt;
    private String documentId;
    private String documentTypeId;
    private String alias;
    private String fileName;


    private static class MetaInformation {
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String country;
        private String postalCode;
        private String lastName;
        private String firstName;
        private String dateOfBirth;

        public MetaInformation() {

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

        public String getCountry() {
            return country;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getPostalCode() {
            return postalCode;
        }
    }
}
