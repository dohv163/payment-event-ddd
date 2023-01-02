package com.example.demo.interfaces.rest.controller;

import com.example.demo.application.PaymentProcessManager;
import com.example.demo.domain.command.PerformPayment;
import com.example.demo.domain.shared.CommandFailure;
import com.example.demo.domain.vo.*;
import com.example.demo.interfaces.rest.model.PerformPaymentRequest;
import com.example.demo.interfaces.rest.model.PerformPaymentResponse;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/payments")
public class PaymentController {

    private final PaymentProcessManager paymentProcessManager;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Callable<CompletionStage<ResponseEntity<?>>> process(@Valid @RequestBody PerformPaymentRequest request) {

        log.info("Request {}", request);

        return () -> {
            log.info("Callable...");

            PerformPayment performPayment = PerformPayment.commandOf(
                    new CustomerId(request.getCustomerId()),
                    PaymentIntent.valueOf(request.getPaymentIntent()),
                    PaymentMethod.valueOf(request.getPaymentMethod()),
                    request.getTransaction());

            CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> promise = paymentProcessManager.process(performPayment);
            return promise.thenApply(acceptOrReject -> acceptOrReject.fold(
                    reject -> ResponseEntity.badRequest().body(reject),
                    accept -> ResponseEntity.accepted().body(new PerformPaymentResponse(accept._1.id, accept._2.name()))
            ));
        };


    }


}
