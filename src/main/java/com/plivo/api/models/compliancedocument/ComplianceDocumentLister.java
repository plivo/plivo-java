package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceDocumentLister extends Lister<ComplianceDocument> {


    private String limit;
    private String offset;

    public ComplianceDocumentLister limit(String limit) {
        this.limit = limit;
        return this;
    }

    public ComplianceDocumentLister offset(String offset) {
        this.offset = offset;
        return this;
    }


    @Override
    protected Call<ListResponse<ComplianceDocument>> obtainCall() {
        return client().getApiService().complianceDocumentList(client().getAuthId(), toMap());
    }
}
