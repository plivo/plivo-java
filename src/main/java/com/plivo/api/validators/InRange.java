package com.plivo.api.validators;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target({FIELD, PARAMETER})
@Retention(value = RUNTIME)
public @interface InRange {

  /**
   * @return error message to return when validation fails
   */
  String message() default "value not in range";

  /**
   * @return min value the element must be higher than or equal to
   */
  int min();

  /**
   * @return max value the element must be lesser than or equal to
   */
  int max();

}
