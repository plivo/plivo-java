package com.plivo.api.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(value = RUNTIME)
public @interface UrlValues {
  /**
   * @return error message to return when validation fails
   */
  String message() default "is not a valid URL";

  /**
   * @return array of possible options
   */
  String[] options() default {};

  /**
   * @return caseSensitive of possible options
   */
  boolean caseSensitive() default false;
}
