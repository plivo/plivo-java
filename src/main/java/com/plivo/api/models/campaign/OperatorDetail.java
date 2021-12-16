package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class OperatorDetail  {
    private String brandTier;
    private String tpm;
    /**
     * @return String return the brandTier
     */
    public String getBrandTier() {
        return brandTier;
    }

    /**
     * @return String return the tpm
     */
    public String getTpm() {
        return tpm;
    }
}