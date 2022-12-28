package com.example.demo.domain.command.handler;

import com.example.demo.domain.command.ConfirmPayment;
import com.example.demo.domain.entity.PaymentEventRepository;
import com.example.demo.domain.event.PaymentConfirmed;
import com.example.demo.domain.shared.CommandFailure;
import com.example.demo.domain.shared.CommandHandler;
import com.example.demo.domain.vo.PaymentEventId;
import com.example.demo.domain.vo.PaymentId;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletionStage;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConfirmPaymentHandler implements CommandHandler<ConfirmPayment, PaymentConfirmed, PaymentId> {

    private final PaymentEventRepository paymentEventRepository;

    @Override
    public CompletionStage<Either<CommandFailure, PaymentConfirmed>> handle(ConfirmPayment command, PaymentId entityId) {

        log.info("Handle Command {}", command);

        PaymentConfirmed event = PaymentConfirmed.eventOf(
                entityId,
                command.getCustomerId(),
                command.getTimestamp()
        );
        CompletionStage<PaymentEventId> storePromise = paymentEventRepository.store(event);
        return storePromise.thenApply(paymentEventId -> Either.right(event));
    }
}
