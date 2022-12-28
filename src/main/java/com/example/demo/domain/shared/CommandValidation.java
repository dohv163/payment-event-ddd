package com.example.demo.domain.shared;

import io.vavr.control.Either;

public interface CommandValidation<C extends Command> {

  Either<CommandFailure, C> acceptOrReject(C command);

}
