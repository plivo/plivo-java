package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.BaseResource;

//{
//        "api_id": "7191ebb2-00a8-11eb-8794-0242ac110004",
//        "meta_information": {
//        "address_line_1": "France",
//        "address_line_2": "FR2",
//        "city": "Doc11",
//        "country": "FR",
//        "postal_code": "wq211"
//        }
//}
public class ComplianceDocument extends BaseResource {
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

    private MetaInformation metaInformation;

    public static ComplianceDocumentGetter getter(String id) {
        return new ComplianceDocumentGetter(id);
    }

    public static ComplianceDocumentCreator creator(String endUserId, String documentTypeId, String alias) {
        return new ComplianceDocumentCreator(endUserId, documentTypeId, alias);
    }

    public ComplianceDocumentUpdater updater() {
        return new ComplianceDocumentUpdater(getId());
    }

    public ComplianceDocumentDeleter deleter() {
        return new ComplianceDocumentDeleter(getId());
    }

    public static ComplianceDocumentLister lister() {
        return new ComplianceDocumentLister();
    }

    @Override
    public String getId() {
        return documentId;
    }
}
