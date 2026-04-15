package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseRequest;
import com.plivo.api.util.Utils;
import java.io.IOException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Response;

public class PhoneNumberComplianceRequirementLister extends BaseRequest<PhoneNumberComplianceRequirement> {

    private String countryIso;
    private String numberType;
    private String userType;

    public PhoneNumberComplianceRequirementLister countryIso(String countryIso) {
        this.countryIso = countryIso;
        return this;
    }

    public PhoneNumberComplianceRequirementLister numberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public PhoneNumberComplianceRequirementLister userType(String userType) {
        this.userType = userType;
        return this;
    }

    @Override
    public PhoneNumberComplianceRequirementLister client(final PlivoClient plivoClient) {
        this.plivoClient = plivoClient;
        return this;
    }

    private Map<String, Object> toMap() {
        client();
        return Utils.objectToMap(PlivoClient.getObjectMapper(), this);
    }

    protected Call<PhoneNumberComplianceRequirement> obtainCall() {
        return client().getApiService().phoneNumberComplianceRequirementList(client().getAuthId(), toMap());
    }

    public PhoneNumberComplianceRequirement list() throws IOException, PlivoRestException, PlivoValidationException {
        validate();
        Response<PhoneNumberComplianceRequirement> response = obtainCall().execute();
        handleResponse(response);
        return response.body();
    }
}
