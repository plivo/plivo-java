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
  String message1() default "value not in range";

  /**
   * @return error message to return when validation fails
   */
  String message2() default " Destination value not in range";

  /**
   * @return error message to return when validation fails
   */
  String message3() default "Destination values must be integer";

  /**
   * @return error message to return when validation fails
   */
  String message4() default "must be integer or string";

  /**
   * @return min value the element must be higher than or equal to
   */
  int lowerbound();

  /**
   * @return max value the element must be lesser than or equal to
   */
  int upperbound();

}
