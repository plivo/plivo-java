package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.BaseResource;

public class ComplianceApplication extends BaseResource {
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

    public static ComplianceApplicationGetter getter(String id) {
        return new ComplianceApplicationGetter(id);
    }

    public static ComplianceApplicationCreator creator(String name, String lastName, String[] documentIds) {
        return new ComplianceApplicationCreator(name, lastName, documentIds);
    }

    public ComplianceApplicationUpdater updater() {
        return new ComplianceApplicationUpdater(getComplianceApplicationId());
    }

    public ComplianceApplicationDeleter deleter() {
        return new ComplianceApplicationDeleter(getComplianceApplicationId());
    }

    public static ComplianceApplicationLister lister() {
        return new ComplianceApplicationLister();
    }

    public String getNumberType() {
        return numberType;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getEndUserId() {
        return endUserId;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public String getAlias() {
        return alias;
    }

    public String getComplianceApplicationId() {
        return complianceApplicationId;
    }

    public String getComplianceRequirementId() {
        return complianceRequirementId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getId() {
        return complianceApplicationId;
    }
}
