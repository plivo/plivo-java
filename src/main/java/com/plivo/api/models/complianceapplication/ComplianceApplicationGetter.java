package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ComplianceApplicationGetter extends Getter<ComplianceApplication> {

    public ComplianceApplicationGetter(String id) {
        super(id);
    }

    @Override
    protected Call<ComplianceApplication> obtainCall() {
        return client().getApiService().complianceApplicationGet(client().getAuthId(), id);
    }
}
