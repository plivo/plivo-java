package com.plivo.api.validators;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.BaseRequest;
import com.plivo.api.models.base.BaseResource;
import com.plivo.api.util.Utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Validate {


  private static final Pattern urlPattern = Pattern.compile("r'(http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+|None)'");
  private static final String COLON = ": ";


  private static Object fetchValue(Field field, BaseRequest request) {
    // Find the correct method
    for (Method method: request.getClass().getMethods()) {
      if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)) && (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))) {
        try {
          return method.invoke(request);
        } catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  private static boolean isNotAmong(String[] options, String element, boolean caseSensitive) {
    for (String opt: options) {
      if (!caseSensitive && opt.equalsIgnoreCase(element)) {
        return false;
      } else if (opt.equals(element)) {
        return false;
      }
    }
    return true;
  }

  private static String composeErrorMessage(String fieldName, String errorMessage) {
    return fieldName + COLON + errorMessage;
  }

  public static void check(BaseRequest request) throws InvalidRequestException {
    Field[] fields = request.getClass().getDeclaredFields();
    for (Field field: fields) {
      Object value = fetchValue(field, request);
      if (value == null) {
        continue;
      }
      Annotation[] annotations = field.getAnnotations();
      for (Annotation annotation: annotations) {
        if (annotation instanceof InRange) {
          int actualValue = (int) value;
          if ((((InRange) annotation).min() > actualValue) || (((InRange) annotation).max() < actualValue)) {
            throw new InvalidRequestException(composeErrorMessage(field.getName(), ((InRange) annotation).message()));
          }
        } else if (annotation instanceof OneOf) {
          String actualValue = (String) value;
          if (isNotAmong(((OneOf) annotation).options(), actualValue, ((OneOf) annotation).caseSensitive())) {
            throw new InvalidRequestException(composeErrorMessage(field.getName(), ((OneOf) annotation).message()));
          }
        } else if (annotation instanceof UrlValues) {
          String actualValue = (String) value;
          if ((!urlPattern.matcher(actualValue).matches() && isNotAmong(((UrlValues) annotation).options(), actualValue, ((UrlValues) annotation).caseSensitive()))) {
            throw new InvalidRequestException(composeErrorMessage(field.getName(), ((UrlValues) annotation).message()));
          }
        } else if (annotation instanceof MultiOf) {
          if (!(value instanceof String[])) {
            continue;
          }
          String[] actualValue = (String[]) value;
          for (String val: actualValue) {
            if (isNotAmong(((MultiOf) annotation).options(), val, ((MultiOf) annotation).caseSensitive())) {
              throw new InvalidRequestException(composeErrorMessage(field.getName(), ((MultiOf) annotation).message()));
            }
          }
        } else if (annotation instanceof SubAccount) {
          String actualValue = (String) value;
          if (!Utils.isSubaccountIdValid(actualValue)) {
            throw new InvalidRequestException(composeErrorMessage(field.getName(), ((SubAccount) annotation).message()));
          }
        }
      }
    }
  }
}
