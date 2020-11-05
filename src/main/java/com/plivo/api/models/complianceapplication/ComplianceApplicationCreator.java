package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class ComplianceApplicationCreator extends Creator<ComplianceApplicationCreateResponse> {

    private String endUserId;
    private String[] documentIds;
    private String alias;
    private String complianceRequirementId;
    private String endUserType;
    private String countryIso2;
    private String numberType;

    ComplianceApplicationCreator(String alias, String endUserId, String[] documentIds) {
        if (!Utils.allNotNull(alias, endUserId)) {
            throw new IllegalArgumentException("alias, endUserId must not be null");
        }

        this.alias = alias;
        this.endUserId = endUserId;
        this.documentIds = documentIds;
    }

    public void setComplianceRequirementId(String complianceRequirementId) {
        this.complianceRequirementId = complianceRequirementId;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public void setEndUserType(String endUserType) {
        this.endUserType = endUserType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    @Override
    protected Call<ComplianceApplicationCreateResponse> obtainCall() {
        return client().getApiService().complianceApplicationCreate(client().getAuthId(), this);
    }
}
