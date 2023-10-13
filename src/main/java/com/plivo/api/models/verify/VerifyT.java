package com.plivo.api.models.verify;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.actions.CallStreamCreateResponse;
import com.plivo.api.models.call.actions.CallStreamCreator;
import okhttp3.ResponseBody;

import java.io.IOException;

public class VerifyT {
  public static void main(String[] args) throws IOException, PlivoRestException, PlivoValidationException {
    Plivo.init("MADCHANDRESH02TANK06","OTljNmVmOGVkNGZhNjJlOWIyMWM0ZDI0ZjQwZDdk");
//    try {
//
//      InitiateVerifyResponse resp = Verify.initiateVerify().
//                                          phoneNumber("919571740370").
//                                          alias("test-saksham-1").
//                                          channel("call").create();
//        System.out.println(resp);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

//    try {
//
//      VerifyCallerIdResponse resp = Verify.verifyCallerId("67965143-9f96-48bf-9aec-64d55cf11504").otp("406359").create();
//      System.out.println(resp);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//    try {
//
//      UpdateVerifiedCallerIdResponse resp = Verify.updateVerifiedCallerID("919571740370").alias("test-saksham-2").update();
//      System.out.println(resp);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
    try {
      GetVerifiedCallerIdResponse resp = Verify.getVerifiedCallerID("919571740370").get();
      System.out.println(resp);
    } catch (Exception e) {
      e.printStackTrace();
    }

//    try {
//
//      ListVerifiedCallerIdResponse resp = Verify.listVerifiedCallerID().get();
//      System.out.println(resp);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//    try {
//      Verify resp = Verify.deleteVerifiedCallerID("919571740370").delete();
//      System.out.println(resp);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }



  }

}
