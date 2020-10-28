package com.plivo.api.models.complianceapplication;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.BaseResource;

import java.io.IOException;


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
    private Document[] documents;

    public static ComplianceApplicationGetter getter(String id) {
        return new ComplianceApplicationGetter(id);
    }

    public static ComplianceApplicationCreator creator(String alias, String endUserId, String[] documentIds) {
        return new ComplianceApplicationCreator(alias, endUserId, documentIds);
    }

    public static ComplianceApplicationUpdater updater(String id) {
        return new ComplianceApplicationUpdater(id);
    }

    public static ComplianceApplicationDeleter deleter(String id) {
        return new ComplianceApplicationDeleter(id);
    }

    public static ComplianceApplicationLister lister() {
        return new ComplianceApplicationLister();
    }

    public ComplianceApplication submit() throws IOException, PlivoRestException {
        return new ComplianceApplicationSubmitter(getComplianceApplicationId()).submit();
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
