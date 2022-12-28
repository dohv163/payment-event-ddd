package com.example.demo.domain.command.validation;

import com.example.demo.domain.command.PerformPayment;
import com.example.demo.domain.shared.CommandFailure;
import com.example.demo.domain.shared.CommandValidation;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class PerformPaymentValidator implements CommandValidation<PerformPayment> {

  @Override
  public Either<CommandFailure, PerformPayment> acceptOrReject(PerformPayment command) {
    return Either.right(command);
  }
}
