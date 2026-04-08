package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class PhoneNumberComplianceLister extends Lister<PhoneNumberCompliance> {

    private String status;
    private String countryIso;
    private String numberType;
    private String userType;
    private String alias;
    private String expand;

    public String status() {
        return this.status;
    }

    public PhoneNumberComplianceLister status(String status) {
        this.status = status;
        return this;
    }

    public String countryIso() {
        return this.countryIso;
    }

    public PhoneNumberComplianceLister countryIso(String countryIso) {
        this.countryIso = countryIso;
        return this;
    }

    public String numberType() {
        return this.numberType;
    }

    public PhoneNumberComplianceLister numberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public String userType() {
        return this.userType;
    }

    public PhoneNumberComplianceLister userType(String userType) {
        this.userType = userType;
        return this;
    }

    public String alias() {
        return this.alias;
    }

    public PhoneNumberComplianceLister alias(String alias) {
        this.alias = alias;
        return this;
    }

    public String expand() {
        return this.expand;
    }

    public PhoneNumberComplianceLister expand(String expand) {
        this.expand = expand;
        return this;
    }

    @Override
    protected Call<ListResponse<PhoneNumberCompliance>> obtainCall() {
        return client().getApiService().phoneNumberComplianceList(client().getAuthId(), toMap());
    }
}
