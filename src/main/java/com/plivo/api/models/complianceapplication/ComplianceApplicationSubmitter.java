package com.plivo.api.models.complianceapplication;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Getter;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ComplianceApplicationSubmitter extends Getter<ComplianceApplication> {

    public ComplianceApplicationSubmitter(String id) {
        super(id);
    }

    @Override
    protected Call<ComplianceApplication> obtainCall() {
        return client().getApiService().complianceApplicationSubmit(client().getAuthId(), id);
    }

    public ComplianceApplication submit() throws IOException, PlivoRestException {
        Response<ComplianceApplication> response = obtainCall().execute();

        handleResponse(response);

        return response.body();
    }
}
