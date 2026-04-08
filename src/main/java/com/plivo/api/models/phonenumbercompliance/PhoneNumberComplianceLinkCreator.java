package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.Creator;
import retrofit2.Call;

import java.util.List;

public class PhoneNumberComplianceLinkCreator extends Creator<PhoneNumberComplianceLinkResponse> {

    private List<PhoneNumberComplianceLinkNumber> numbers;

    public List<PhoneNumberComplianceLinkNumber> getNumbers() {
        return numbers;
    }

    public PhoneNumberComplianceLinkCreator numbers(List<PhoneNumberComplianceLinkNumber> numbers) {
        this.numbers = numbers;
        return this;
    }

    @Override
    protected Call<PhoneNumberComplianceLinkResponse> obtainCall() {
        return client().getApiService().phoneNumberComplianceLinkCreate(client().getAuthId(), this);
    }
}
