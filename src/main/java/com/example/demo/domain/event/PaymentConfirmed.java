package com.example.demo.domain.event;

import com.example.demo.domain.vo.CustomerId;
import com.example.demo.domain.vo.PaymentEventId;
import com.example.demo.domain.vo.PaymentEventType;
import com.example.demo.domain.vo.PaymentId;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "eventOf")
public class PaymentConfirmed implements PaymentEvent{

    private final PaymentEventId eventId = new PaymentEventId();
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final LocalDateTime timestamp;

    @Override
    public PaymentEventType getEventType() {
        return PaymentEventType.PAYMENT_CONFIRMED;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
