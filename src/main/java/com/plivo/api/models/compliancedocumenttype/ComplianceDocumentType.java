package com.plivo.api.models.compliancedocumenttype;

import com.plivo.api.models.base.BaseResource;

public class ComplianceDocumentType extends BaseResource {
    public static class Information {
        private String fieldName;
        private String fieldType;
        private String friendlyName;
        private String helpText;
        private String maxLength;
        private String minLength;
        private String format;

        public Information() {

        }

        public String getFriendlyName() {
            return friendlyName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public String getFieldType() {
            return fieldType;
        }

        public String getFormat() {
            return format;
        }

        public String getHelpText() {
            return helpText;
        }

        public String getMaxLength() {
            return maxLength;
        }

        public String getMinLength() {
            return minLength;
        }
    }

    private String createdAt;
    private String documentTypeID;
    private String documentName;
    private String description;
    private String proofRequired;
    private Information[] information;

    public static ComplianceDocumentTypeLister lister() {
        return new ComplianceDocumentTypeLister();
    }

    public static ComplianceDocumentTypeGetter getter(String id) {
        return new ComplianceDocumentTypeGetter(id);
    }

    @Override
    public String getId() {
        return documentTypeID;
    }

    public Information[] getInformation() {
        return information;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getDocumentTypeID() {
        return documentTypeID;
    }

    public String getProofRequired() {
        return proofRequired;
    }
}
