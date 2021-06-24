package com.plivo.api.validators;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.util.Utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Validate {


  private static final Pattern urlPattern = Pattern.compile("r'(http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+|None)'");
  private static final String COLON = ": ";


  private static Object fetchValue(Field field, Object request) {
    // Find the correct method
    for (Method method: request.getClass().getMethods()) {
      if (method.getName().equalsIgnoreCase(field.getName()) && field.getType().toString().equals(method.getReturnType().toString())) {
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

  public static void validMultipleIntegers(String paramName, String paramvalue, int lowerbound, int upperbound) throws PlivoValidationException {
    String []values = paramvalue.split("<");
    for (int i=0; i<values.length; i++){
      try{
        int val = Integer.parseInt(values[i]);
        if (val < lowerbound || val > upperbound ){
          System.out.println(lowerbound);
          System.out.println(val);
          throw new PlivoValidationException(composeErrorMessage(paramName, "Values passed in the string must be in the range [ " + Integer.toString(lowerbound) + ", " + Integer.toString(upperbound) + " ]"));
        }
      }catch (NumberFormatException e){
        throw new PlivoValidationException(composeErrorMessage(paramName, "Values passed in the string must be integers"));
      }
    }
  }

  public static void check(Object request) throws PlivoValidationException {
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
            throw new PlivoValidationException(composeErrorMessage(field.getName(), ((InRange) annotation).message()));
          }
        } else if (annotation instanceof OneOf) {
          String actualValue = (String) value;
          if (isNotAmong(((OneOf) annotation).options(), actualValue, ((OneOf) annotation).caseSensitive())) {
            throw new PlivoValidationException(composeErrorMessage(field.getName(), ((OneOf) annotation).message()));
          }
        } else if (annotation instanceof UrlValues) {
          String actualValue = (String) value;
          if ((!urlPattern.matcher(actualValue).matches() && isNotAmong(((UrlValues) annotation).options(), actualValue, ((UrlValues) annotation).caseSensitive()))) {
            throw new PlivoValidationException(composeErrorMessage(field.getName(), ((UrlValues) annotation).message()));
          }
        } else if (annotation instanceof MultiOf) {
          if (!(value instanceof String[])) {
            continue;
          }
          String[] actualValue = (String[]) value;
          for (String val: actualValue) {
            if (isNotAmong(((MultiOf) annotation).options(), val, ((MultiOf) annotation).caseSensitive())) {
              throw new PlivoValidationException(composeErrorMessage(field.getName(), ((MultiOf) annotation).message()));
            }
          }
        } else if (annotation instanceof SubAccount) {
          String actualValue = (String) value;
          if (!Utils.isSubaccountIdValid(actualValue)) {
            throw new PlivoValidationException(composeErrorMessage(field.getName(), ((SubAccount) annotation).message()));
          }
        } else if (annotation instanceof MultipleValidIntegers) {
          if( value instanceof Integer) {
            Integer actualValue = (Integer) value;
          } else if ( value instanceof String){
            String actualValue = (String) value;
            String []values = actualValue.split("<");
            for (int i=0; i<values.length; i++){
              try{
                Integer.parseInt(values[i]);
              }catch (NumberFormatException e){
                throw new PlivoValidationException(composeErrorMessage(field.getName(), ((MultipleValidIntegers) annotation).message()));
              }
            }
          } else{
            throw new PlivoValidationException(composeErrorMessage(field.getName(), ((MultipleValidIntegers) annotation).message()));
          }
        }
      }
    }
  }
}
