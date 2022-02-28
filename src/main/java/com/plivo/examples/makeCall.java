package com.plivo.examples;

import java.io.IOException;
import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.application.Application;
import com.plivo.api.models.application.ApplicationCreateResponse;

/**
 * Example for Application create
 */
class ApplicationCreate {
  public static void main(String [] args) {
    Plivo.init("MADCHANDRESH02TANK06","OTljNmVmOGVkNGZhNjJlOWIyMWM0ZDI0ZjQwZDdk");
    try {
      ApplicationCreateResponse response = Application.creator("AjayTesting1")
        .create();

      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }
}