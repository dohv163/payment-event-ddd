package com.example.demo.domain.event;

import com.example.demo.domain.vo.CustomerId;
import com.example.demo.domain.vo.PaymentEventId;
import com.example.demo.domain.vo.PaymentEventType;
import com.example.demo.domain.vo.PaymentId;
import com.example.demo.domain.vo.PaymentIntent;
import com.example.demo.domain.vo.PaymentMethod;
import com.example.demo.domain.vo.Transaction;
import java.time.LocalDateTime;
import lombok.Value;

@Value(staticConstructor = "eventOf")
public class PaymentRequested implements PaymentEvent{

  private final PaymentEventId eventId = new PaymentEventId();
  private final PaymentId paymentId;
  private final CustomerId customerId;
  private final PaymentIntent paymentIntent;
  private final PaymentMethod paymentMethod;
  private final Transaction transaction;
  private final LocalDateTime timestamp;

  @Override
  public PaymentEventType getEventType() {
    return PaymentEventType.PAYMENT_REQUESTED;
  }

  @Override
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

}
