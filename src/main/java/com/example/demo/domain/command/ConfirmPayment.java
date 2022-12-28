package com.example.demo.domain.command;

import com.example.demo.domain.vo.CustomerId;
import com.example.demo.domain.vo.PaymentId;
import java.time.LocalDateTime;
import lombok.Value;

@Value(staticConstructor = "commandOf")
public class ConfirmPayment implements PaymentCommand {

  private final PaymentId paymentId;
  private final CustomerId customerId;
  private final LocalDateTime timestamp = LocalDateTime.now();

}
