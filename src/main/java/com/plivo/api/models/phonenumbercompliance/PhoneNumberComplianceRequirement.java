package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.BaseResource;

import java.util.List;

public class PhoneNumberComplianceRequirement extends BaseResource {

    private String requirementId;
    private String countryIso;
    private String numberType;
    private String userType;
    private List<Object> documentTypes;

    public static PhoneNumberComplianceRequirementLister lister() {
        return new PhoneNumberComplianceRequirementLister();
    }

    @Override
    public String getId() {
        return requirementId;
    }

    public String getRequirementId() {
        return requirementId;
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

    public List<Object> getDocumentTypes() {
        return documentTypes;
    }
}
