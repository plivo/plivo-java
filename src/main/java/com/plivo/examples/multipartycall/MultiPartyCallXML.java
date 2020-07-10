package com.plivo.examples.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoXmlException;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;
import com.plivo.api.xml.MultiPartyCall;
import com.plivo.api.xml.Response;

public class MultiPartyCallXML {

  public static void main(String[] args) throws PlivoValidationException, PlivoXmlException {
    Response resp = new Response();
    resp.children(new MultiPartyCall("Bank of Spain", MultiPartyCallUtils.supervisor));
    System.out.println(resp.toXmlString());
  }
}
