package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.Deleter;
import com.plivo.api.models.complianceapplication.ComplianceApplication;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ComplianceApplicationDeleter extends Deleter<ComplianceApplication> {

    public ComplianceApplicationDeleter(String id) {
        super(id);
    }

    @Override
    protected Call<ResponseBody> obtainCall() {
        return client().getApiService().complianceApplicationDelete(client().getAuthId(), id);
    }
}

