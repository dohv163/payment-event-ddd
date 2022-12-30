package com.example.demo.domain.command.handler;

import com.example.demo.domain.command.PerformPayment;
import com.example.demo.domain.command.validation.PerformPaymentValidator;
import com.example.demo.domain.entity.PaymentEventRepository;
import com.example.demo.domain.event.PaymentRequested;
import com.example.demo.domain.shared.CommandFailure;
import com.example.demo.domain.shared.CommandHandler;
import com.example.demo.domain.vo.PaymentEventId;
import com.example.demo.domain.vo.PaymentId;
import io.vavr.control.Either;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PerformPaymentHandler implements
    CommandHandler<PerformPayment, PaymentRequested, PaymentId> {

  private final PaymentEventRepository paymentEventRepository;
  private final PerformPaymentValidator performPaymentValidator;

  PerformPaymentHandler(PaymentEventRepository paymentEventRepository,
      PerformPaymentValidator performPaymentValidator) {
    this.paymentEventRepository = paymentEventRepository;
    this.performPaymentValidator = performPaymentValidator;
  }

  @Override
  public CompletionStage<Either<CommandFailure, PaymentRequested>> handle(PerformPayment command,
      PaymentId entityId) {

    log.info("Handle command {}", command);

    return performPaymentValidator.acceptOrReject(command).fold(
        reject -> CompletableFuture.completedFuture(Either.left(reject)),
        accept -> {
          PaymentRequested event = PaymentRequested.eventOf(
              entityId,
              command.getCustomerId(),
              command.getPaymentIntent(),
              command.getPaymentMethod(),
              command.getTransaction(),
              command.getTimestamp()
          );
          CompletionStage<PaymentEventId> storePromise = paymentEventRepository.store(event);
          return storePromise.thenApply(paymentEventId -> Either.right(event));
        }
    );
  }
}
