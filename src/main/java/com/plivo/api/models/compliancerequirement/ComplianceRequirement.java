package com.plivo.api.models.compliancerequirement;

import com.plivo.api.models.base.BaseResource;

public class ComplianceRequirement extends BaseResource {

    public static class DocumentType {
        public static class AcceptableDocument {
            private String documentTypeId;
            private String documentTypeName;

            public AcceptableDocument() {

            }

            public String getDocumentTypeId() {
                return documentTypeId;
            }

            public String getDocumentTypeName() {
                return documentTypeName;
            }
        }

        private String name;
        private String scope;
        private AcceptableDocument[] acceptableDocuments;

        public String getName() {
            return name;
        }

        public String getScope() {
            return scope;
        }

        public AcceptableDocument[] getAcceptableDocuments() {
            return acceptableDocuments;
        }

        public DocumentType() {

        }
    }

    private String complianceRequirementID;
    private String countryIso2;
    private String endUserType;
    private String numberType;
    private DocumentType[] acceptableDocumentTypes;


    public static ComplianceRequirementLister lister(String number) {
        return new ComplianceRequirementLister(number);
    }

    public static ComplianceRequirementGetter getter(String id) {
        return new ComplianceRequirementGetter(id);
    }

    @Override
    public String getId() {
        return complianceRequirementID;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public DocumentType[] getAcceptableDocumentTypes() {
        return acceptableDocumentTypes;
    }

    public String getComplianceRequirementID() {
        return complianceRequirementID;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public String getNumberType() {
        return numberType;
    }
}
