package com.example.demo.application;

import com.example.demo.domain.command.PerformPayment;
import com.example.demo.domain.shared.CommandFailure;
import com.example.demo.domain.vo.PaymentId;
import com.example.demo.domain.vo.PaymentStatus;
import io.vavr.Tuple2;
import io.vavr.control.Either;

import java.util.concurrent.CompletionStage;

public interface PaymentProcessManager {
    CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> process(PerformPayment command);

}
