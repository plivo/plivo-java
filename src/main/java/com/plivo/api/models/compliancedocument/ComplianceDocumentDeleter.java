package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ComplianceDocumentDeleter extends Deleter<ComplianceDocument> {

    public ComplianceDocumentDeleter(String id) {
        super(id);
    }

    @Override
    protected Call<ResponseBody> obtainCall() {
        return client().getApiService().complianceDocumentDelete(client().getAuthId(), id);
    }
}

