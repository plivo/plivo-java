package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ComplianceDocumentGetter extends Getter<ComplianceDocument> {

    public ComplianceDocumentGetter(String id) {
        super(id);
    }

    @Override
    protected Call<ComplianceDocument> obtainCall() {
        return client().getApiService().complianceDocumentGet(client().getAuthId(), id);
    }
}
