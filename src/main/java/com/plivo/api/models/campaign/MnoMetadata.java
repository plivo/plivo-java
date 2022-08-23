package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class MnoMetadata  {
    @JsonProperty("T-Mobile")
    private OperatorDetail tMobile;
    @JsonProperty("AT&T")
    private OperatorDetail uSCellular;
    @JsonProperty("Verizon Wireless")

    /**
     * @return OperatorDetail return the uSCellular
     */
    public OperatorDetail getUSCellular() {
        return uSCellular;
    }
}