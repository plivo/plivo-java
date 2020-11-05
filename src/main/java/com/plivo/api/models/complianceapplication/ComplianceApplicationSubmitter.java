package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.Submitter;
import retrofit2.Call;

public class ComplianceApplicationSubmitter extends Submitter<ComplianceApplicationCreateResponse> {

    public ComplianceApplicationSubmitter(String id) {
        super(id);
    }


    @Override
    protected Call<ComplianceApplicationCreateResponse> obtainCall() {
        return client().getApiService().complianceApplicationSubmit(client().getAuthId(), id,this);
    }
}
