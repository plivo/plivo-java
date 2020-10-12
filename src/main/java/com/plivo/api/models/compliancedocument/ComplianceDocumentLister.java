package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceDocumentLister extends Lister<ComplianceDocument> {

    @Override
    protected Call<ListResponse<ComplianceDocument>> obtainCall() {
        return client().getApiService().complianceDocumentList(client().getAuthId(), toMap());
    }
}
