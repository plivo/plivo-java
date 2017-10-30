package com.plivo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

public class TestUtil {

  public static String loadFixture(String name) {
    BufferedReader bufferedReader = null;
    try {
      InputStream inputStream = null;
      try {
        // TODO FIXME
        inputStream = TestUtil.class.getResourceAsStream(name);
      } catch (Exception e) {
      }

      if (inputStream == null) {
        return null;
      }

      bufferedReader = new BufferedReader(
        new InputStreamReader(
          inputStream, "UTF-8"
        ));
      return bufferedReader.lines().collect(Collectors.joining("\n"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}
