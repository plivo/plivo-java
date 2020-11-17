package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.BaseResponse;

public class ComplianceApplicationCreateResponse extends BaseResponse {
    private String endUserId;
    private String endUserType;
    private String createdAt;
    private String numberType;
    private String status;
    private String countryIso2;
    private String alias;
    private String complianceApplicationId;
    private String complianceRequirementId;

    private static class Document {
        private String documentId;
        private String documentName;
        private String documentTypeId;
        private String documentTypeName;
        private String name;
        private String scope;
    }

    private Document[] documents;

    public String getEndUserId() {
        return endUserId;
    }

    public String getStatus() {
        return status;
    }

    public String getComplianceRequirementId() {
        return complianceRequirementId;
    }

    public String getComplianceApplicationId() {
        return complianceApplicationId;
    }

    public String getAlias() {
        return alias;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public String getNumberType() {
        return numberType;
    }

    public Document[] getDocuments() {
        return documents;
    }
}
