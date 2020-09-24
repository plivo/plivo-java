package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ComplianceApplicationSubmitter extends Getter<ComplianceApplication> {

    public ComplianceApplicationSubmitter(String id) {
        super(id);
    }

    @Override
    protected Call<ComplianceApplication> obtainCall() {
        return client().getApiService().complianceApplicationSubmit(client().getAuthId(), id);
    }
}
