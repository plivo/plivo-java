package com.plivo.api.models.compliancerequirement;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ComplianceRequirementGetter extends Getter<ComplianceRequirement> {

    public ComplianceRequirementGetter(String id) {
        super(id);
    }

    @Override
    protected Call<ComplianceRequirement> obtainCall() {
        return client().getApiService().complianceRequirementGet(client().getAuthId(), id);
    }
}
