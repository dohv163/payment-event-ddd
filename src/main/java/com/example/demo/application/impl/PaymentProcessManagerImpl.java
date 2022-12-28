package com.example.demo.application.impl;

import com.example.demo.application.PaymentProcessManager;
import com.example.demo.domain.command.ConfirmPayment;
import com.example.demo.domain.command.PerformPayment;
import com.example.demo.domain.entity.Payment;
import com.example.demo.domain.event.PaymentEvent;
import com.example.demo.domain.event.PaymentRequested;
import com.example.demo.domain.shared.CommandFailure;
import com.example.demo.domain.vo.PaymentId;
import com.example.demo.domain.vo.PaymentStatus;
import com.example.demo.infra.util.i18n.I18nCode;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PaymentProcessManagerImpl implements PaymentProcessManager {

    private final ApplicationContext applicationContext;


    @Override
    public CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> process(PerformPayment command) {
        return null;
    }

    public CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> fallback(PerformPayment performPayment) {
        return completed(new CommandFailure(new HashSet<I18nCode>() {{
            add(new I18nCode("SERVICE_UNAVAILABLE"));
        }}));
    }

    private CompletableFuture<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> completed(CommandFailure rejectAuthorization) {
        return completedFuture(left(rejectAuthorization));
    }

    private CompletableFuture<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> completed(PaymentEvent paymentEvent, PaymentStatus paymentStatus) {
        return completedFuture(right(Tuple.of(paymentEvent.getPaymentId(), paymentStatus)));
    }

//    private CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> confirm(Payment payment, PaymentRequested acceptPayment, PaymentAuthorized acceptAuthorization) {
//        ConfirmPayment confirmPayment = ConfirmPayment.commandOf(
//                acceptAuthorization.getPaymentId(),
//                acceptAuthorization.getCustomerId()
//        );
//        CompletionStage<Either<CommandFailure, PaymentConfirmed>> confirmPaymentPromise = payment.handle(confirmPayment);
//        return confirmPaymentPromise.thenApply(paymentConfirmed -> paymentConfirmed.fold(
//                rejectConfirmation -> left(rejectConfirmation),
//                acceptConfirmation -> right(Tuple.of(acceptPayment.getPaymentId(), PaymentStatus.CAPTURED))
//        ));
//    }


}
