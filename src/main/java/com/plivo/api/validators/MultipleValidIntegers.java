package com.plivo.api.validators;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target({FIELD, PARAMETER})
@Retention(value = RUNTIME)
public @interface MultipleValidIntegers {

  /**
   * @return error message to return when validation fails
   */
  String message() default "value must be either integer or string containing integers separated by delimiter '<' ";

}
