package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class ComplianceApplicationUpdater extends Updater<ComplianceApplicationUpdateResponse> {

    private String[] documentIds;

    public ComplianceApplicationUpdater(String id) {
        super(id);
    }

    public String[] getDocumentIds() {
        return documentIds;
    }

    public ComplianceApplicationUpdater setDocumentIds(String[] documentIds) {
        this.documentIds = documentIds;
        return this;
    }


    @Override
    protected Call<ComplianceApplicationUpdateResponse> obtainCall() {
        return client().getApiService().complianceApplicationUpdate(client().getAuthId(), id, this);
    }
}
