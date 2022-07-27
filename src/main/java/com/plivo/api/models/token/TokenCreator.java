package com.plivo.api.models.token;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class TokenCreator extends Creator<TokenCreateResponse> {
          private String iss;
          private String sub;
          private Integer nbf;
          private Integer exp;
          private Boolean incoming_allow;
          private Boolean outgoing_allow;
          private String app;

          TokenCreator(String iss, String sub, Integer nbf, Integer exp, Boolean incoming_allow, Boolean outgoing_allow, String app) {
            this.iss = iss;
            this.sub = sub;
            this.nbf = nbf;
            this.exp = exp;
            this.incoming_allow = incoming_allow;
            this.outgoing_allow = outgoing_allow;
            this.app = app;
          }

          public String iss() {
            return iss;
          }
          public String sub() {
            return sub;
          }
          public Integer nbf() {
            return nbf;
          }
          public Integer exp() {
            return exp;
          }
          public Boolean incoming_allow() {
            return incoming_allow;
          }
          public Boolean outgoing_allow() {
            return outgoing_allow;
          }
          public String app() {
            return app;
          }

}