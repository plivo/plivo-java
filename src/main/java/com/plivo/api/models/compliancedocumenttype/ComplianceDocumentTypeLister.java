package com.plivo.api.models.compliancedocumenttype;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceDocumentTypeLister extends Lister<ComplianceDocumentType> {


    private String limit;
    private String offset;


    public ComplianceDocumentTypeLister limit(String limit) {
        this.limit = limit;
        return this;
    }

    public ComplianceDocumentTypeLister offset(String offset) {
        this.offset = offset;
        return this;
    }

    @Override
    protected Call<ListResponse<ComplianceDocumentType>> obtainCall() {
        return client().getApiService().complianceDocumentTypeList(client().getAuthId(), toMap());
    }
}
