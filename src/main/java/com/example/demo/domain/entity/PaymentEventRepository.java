package com.example.demo.domain.entity;

import com.example.demo.domain.event.PaymentEvent;
import com.example.demo.domain.vo.PaymentEventId;
import java.util.concurrent.CompletionStage;

public interface PaymentEventRepository {

  CompletionStage<PaymentEventId> store(PaymentEvent paymentEvent);

}
