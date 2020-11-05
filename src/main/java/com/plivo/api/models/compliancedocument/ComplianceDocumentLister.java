package com.plivo.api.models.compliancedocument;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ComplianceDocumentLister extends Lister<ComplianceDocument> {
    private String alias = null;
    private String documentTypeId = null;
    private String endUserId = null;

    public String alias() {
      return this.alias;
    }
    public String documentTypeId() {
      return this.documentTypeId;
    }
    public String endUserId() {
      return this.endUserId;
    }

    public ComplianceDocumentLister alias(final String alias) {
      this.alias = alias;
      return this;
    }

    public ComplianceDocumentLister documentTypeId(final String documentTypeId) {
      this.documentTypeId = documentTypeId;
      return this;
    }

    public ComplianceDocumentLister endUserId(final String endUserId) {
      this.endUserId = endUserId;
      return this;
    }
    @Override
    protected Call<ListResponse<ComplianceDocument>> obtainCall() {
        return client().getApiService().complianceDocumentList(client().getAuthId(), toMap());
    }
}
