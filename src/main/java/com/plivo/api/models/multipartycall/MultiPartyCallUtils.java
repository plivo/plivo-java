package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.util.PropertyFilter;
import com.plivo.api.util.Utils;
import com.sun.istack.internal.NotNull;

public class MultiPartyCallUtils {
  private static final String namePrefix = "name_";
  private static final String uuidPrefix = "uuid_";

  public static final String active = "Active";
  public static final String initialized = "Initialized";
  public static final String ended = "Ended";
  public static final String agent = "Agent";
  public static final String customer = "Customer";
  public static final String supervisor = "Supervisor";


  public static String friendlyName(@NotNull String name) throws InvalidRequestException {
    if (name == null) {
      throw new InvalidRequestException("MultiPartyCall name cannot be null");
    }
    return namePrefix + name;
  }

  public static String mpcUuid(@NotNull String uuid) throws InvalidRequestException {
    if (uuid == null) {
      throw new InvalidRequestException("MultiPartyCall uuid cannot be null");
    }
    return uuidPrefix + uuid;
  }

  static void validMultiPartyCallId(String id) throws InvalidRequestException {
    if (id == null) {
      throw new InvalidRequestException("MultiPartyCall identifier cannot be null");
    }
    if (id.startsWith(namePrefix) || id.startsWith(uuidPrefix)) {
      return;
    }
    throw new InvalidRequestException("MultiPartyCall identifier should be prefixed with 'name_'/'uuid_'");
  }

  static void validMultiPartyTime(String fieldName, PropertyFilter<String> time) throws InvalidRequestException {
    if (!Utils.anyNotNull(time.greaterOrEqual(), time.greaterThan(), time.lessOrEqual(), time.lessThan())) {
      throw new InvalidRequestException(String.format("use one of [greaterOrEqual, greaterThan, lessOrEqual, " +
        "lessThan for %s", fieldName));
    }
    if (time.greaterOrEqual() != null && !Utils.isValidTimeString(time.greaterOrEqual())) {
      throw new InvalidRequestException(String.format("invalid greaterOrEqual value: %s", time.greaterOrEqual()));
    }
    if (time.greaterThan() != null && !Utils.isValidTimeString(time.greaterThan())) {
      throw new InvalidRequestException(String.format("invalid greaterThan value: %s", time.greaterThan()));
    }
    if (time.lessOrEqual() != null && !Utils.isValidTimeString(time.lessOrEqual())) {
      throw new InvalidRequestException(String.format("invalid lessOrEqual value: %s", time.lessOrEqual()));
    }
    if (time.lessThan() != null && !Utils.isValidTimeString(time.lessThan())) {
      throw new InvalidRequestException(String.format("invalid lessThan value: %s", time.lessThan()));
    }
  }
}
