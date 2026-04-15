package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.BaseResource;

import java.util.List;

public class PhoneNumberCompliance extends BaseResource {

    private String complianceId;
    private String status;
    private String alias;
    private String countryIso;
    private String numberType;
    private String userType;
    private String callbackUrl;
    private String callbackMethod;
    private String rejectionReason;
    private String createdAt;
    private String updatedAt;
    private Object endUser;
    private List<Object> documents;
    private List<Object> linkedNumbers;

    public static PhoneNumberComplianceCreator creator(String dataJson) {
        return new PhoneNumberComplianceCreator(dataJson);
    }

    public static PhoneNumberComplianceGetter getter(String id) {
        return new PhoneNumberComplianceGetter(id);
    }

    public static PhoneNumberComplianceLister lister() {
        return new PhoneNumberComplianceLister();
    }

    public static PhoneNumberComplianceUpdater updater(String id) {
        return new PhoneNumberComplianceUpdater(id);
    }

    public static PhoneNumberComplianceDeleter deleter(String id) {
        return new PhoneNumberComplianceDeleter(id);
    }

    @Override
    public String getId() {
        return complianceId;
    }

    public String getComplianceId() {
        return complianceId;
    }

    public String getStatus() {
        return status;
    }

    public String getAlias() {
        return alias;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public String getNumberType() {
        return numberType;
    }

    public String getUserType() {
        return userType;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public String getCallbackMethod() {
        return callbackMethod;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Object getEndUser() {
        return endUser;
    }

    public List<Object> getDocuments() {
        return documents;
    }

    public List<Object> getLinkedNumbers() {
        return linkedNumbers;
    }
}
