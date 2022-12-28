package com.example.demo.infra.util.validation;

import java.util.Arrays;
import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

  private ValidEnum annotation;

  @Override
  public void initialize(ValidEnum constraintAnnotation) {
    this.annotation = constraintAnnotation;
  }

  @Override
  public boolean isValid(String valueForValidation, ConstraintValidatorContext context) {
    final boolean[] result = {false};
    Optional<Object[]> enumValues = Optional.ofNullable(this.annotation.conformsTo().getEnumConstants());
    enumValues.ifPresent(values -> Arrays.stream(values).forEach(value -> {
      if ((valueForValidation != null && valueForValidation.equals(value.toString()))
          || (this.annotation.ignoreCase() && valueForValidation.equalsIgnoreCase(value.toString()))) {
        result[0] = true;
      }
    }));
    return result[0];
  }
}
