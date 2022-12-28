package com.example.demo.domain.command;

import com.example.demo.domain.vo.CustomerId;
import com.example.demo.domain.vo.PaymentIntent;
import com.example.demo.domain.vo.PaymentMethod;
import com.example.demo.domain.vo.Transaction;
import java.time.LocalDateTime;
import lombok.Value;

@Value(staticConstructor = "commandOf")
public class PerformPayment implements PaymentCommand {

  private final CustomerId customerId;
  private final PaymentIntent paymentIntent;
  private final PaymentMethod paymentMethod;
  private final Transaction transaction;
  private final LocalDateTime timestamp = LocalDateTime.now();

}
