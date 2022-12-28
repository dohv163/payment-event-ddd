package com.example.demo.domain.event;

import com.example.demo.domain.shared.Event;
import com.example.demo.domain.vo.PaymentEventId;
import com.example.demo.domain.vo.PaymentEventType;
import com.example.demo.domain.vo.PaymentId;
import java.time.LocalDateTime;

public interface PaymentEvent extends Event {

  PaymentEventId getEventId();

  PaymentEventType getEventType();

  PaymentId getPaymentId();

  LocalDateTime getTimestamp();

}
