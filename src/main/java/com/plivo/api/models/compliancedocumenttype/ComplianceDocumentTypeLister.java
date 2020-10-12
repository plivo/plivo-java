package com.plivo.api.models.compliancedocumenttype;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceDocumentTypeLister extends Lister<ComplianceDocumentType> {

    @Override
    protected Call<ListResponse<ComplianceDocumentType>> obtainCall() {
        return client().getApiService().complianceDocumentTypeList(client().getAuthId(), toMap());
    }
}
