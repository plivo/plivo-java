package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.util.PropertyFilter;
import com.plivo.api.util.Utils;
import com.sun.istack.internal.NotNull;

public class MultiPartyCallUtils {
  private static final String namePrefix = "name_";
  private static final String uuidPrefix = "uuid_";

  public static final String active = "Active";
  public static final String initialized = "Initialized";
  public static final String allParticipants = "all";
  public static final String ended = "Ended";
  public static final String agent = "Agent";
  public static final String customer = "Customer";
  public static final String supervisor = "Supervisor";
  public static final String mp3 = "mp3";
  public static final String wav = "wav";


  public static String friendlyName(@NotNull String name) throws PlivoValidationException {
    if (name == null) {
      throw new PlivoValidationException("MultiPartyCall name cannot be null");
    }
    return namePrefix + name;
  }

  public static String mpcUuid(@NotNull String uuid) throws PlivoValidationException {
    if (uuid == null) {
      throw new PlivoValidationException("MultiPartyCall uuid cannot be null");
    }
    return uuidPrefix + uuid;
  }

  static void validMultiPartyCallId(String id) throws PlivoValidationException {
    if (id == null) {
      throw new PlivoValidationException("MultiPartyCall identifier cannot be null");
    }
    if (id.startsWith(namePrefix) || id.startsWith(uuidPrefix)) {
      return;
    }
    throw new PlivoValidationException("MultiPartyCall identifier should be prefixed with 'name_'/'uuid_'");
  }

  static void validMultiPartyTime(String fieldName, PropertyFilter<String> time) throws PlivoValidationException {
    if (!Utils.anyNotNull(time.greaterOrEqual(), time.greaterThan(), time.lessOrEqual(), time.lessThan())) {
      throw new PlivoValidationException(String.format("use one of [greaterOrEqual, greaterThan, lessOrEqual, " +
        "lessThan for %s", fieldName));
    }
    if (time.greaterOrEqual() != null && !Utils.isValidTimeString(time.greaterOrEqual())) {
      throw new PlivoValidationException(String.format("invalid greaterOrEqual value: %s", time.greaterOrEqual()));
    }
    if (time.greaterThan() != null && !Utils.isValidTimeString(time.greaterThan())) {
      throw new PlivoValidationException(String.format("invalid greaterThan value: %s", time.greaterThan()));
    }
    if (time.lessOrEqual() != null && !Utils.isValidTimeString(time.lessOrEqual())) {
      throw new PlivoValidationException(String.format("invalid lessOrEqual value: %s", time.lessOrEqual()));
    }
    if (time.lessThan() != null && !Utils.isValidTimeString(time.lessThan())) {
      throw new PlivoValidationException(String.format("invalid lessThan value: %s", time.lessThan()));
    }
  }
}
