package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class MnoMetadata  {
     private OperatorDetail aTandT;
    private OperatorDetail verizonWireless;
    private OperatorDetail tMobile;
    private OperatorDetail uSCellular;
     /**
     * @return OperatorDetail return the aTandT
     */
    public OperatorDetail getATandT() {
        return aTandT;
    }

   

    /**
     * @return OperatorDetail return the verizonWireless
     */
    public OperatorDetail getVerizonWireless() {
        return verizonWireless;
    }

    

    /**
     * @return OperatorDetail return the tMobile
     */
    public OperatorDetail getTMobile() {
        return tMobile;
    }


    /**
     * @return OperatorDetail return the uSCellular
     */
    public OperatorDetail getUSCellular() {
        return uSCellular;
    }
}