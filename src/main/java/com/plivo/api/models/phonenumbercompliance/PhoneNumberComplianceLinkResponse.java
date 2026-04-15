package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.models.base.BaseResponse;

import java.util.List;

public class PhoneNumberComplianceLinkResponse extends BaseResponse {

    private Integer totalCount;
    private Integer updatedCount;
    private List<Object> report;

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getUpdatedCount() {
        return updatedCount;
    }

    public List<Object> getReport() {
        return report;
    }
}
