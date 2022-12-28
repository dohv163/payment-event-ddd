package com.example.demo.infra.util.validation;

import java.lang.annotation.Documented;
import javax.validation.Payload;

@Documented
public @interface ValidEnum {

  String message() default "invalid.enum";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  Class<? extends java.lang.Enum<?>> conformsTo();

  boolean ignoreCase() default false;

}
