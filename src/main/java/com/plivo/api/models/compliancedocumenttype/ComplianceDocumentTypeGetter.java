package com.plivo.api.models.compliancedocumenttype;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ComplianceDocumentTypeGetter extends Getter<ComplianceDocumentType> {

    public ComplianceDocumentTypeGetter(String id) {
        super(id);
    }

    @Override
    protected Call<ComplianceDocumentType> obtainCall() {
        return client().getApiService().complianceDocumentTypeGet(client().getAuthId(), id);
    }
}
