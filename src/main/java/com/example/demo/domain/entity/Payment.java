package com.example.demo.domain.entity;

import com.example.demo.domain.command.PerformPayment;
import com.example.demo.domain.command.handler.PerformPaymentHandler;
import com.example.demo.domain.shared.AggregateRoot;
import com.example.demo.domain.vo.PaymentId;
import org.springframework.context.ApplicationContext;

public class Payment extends AggregateRoot<Payment, PaymentId> {

  public Payment(ApplicationContext applicationContext) {
    super(applicationContext, new PaymentId());
  }

  public Payment(ApplicationContext applicationContext, PaymentId paymentId) {
    super(applicationContext, paymentId);
  }

  @Override
  public boolean sameIdentityAs(Payment other) {
    return other != null && entityId.sameValueAs(other.entityId);
  }

  @Override
  public PaymentId id() {
    return entityId;
  }

  @Override
  protected AggregateRootBehavior initialBehavior() {
    AggregateRootBehaviorBuilder behaviorBuilder = new AggregateRootBehaviorBuilder();
    behaviorBuilder.setCommandHandler(PerformPayment.class, getHandler(PerformPaymentHandler.class));
//    behaviorBuilder.setCommandHandler(AuthorizePayment.class, getHandler(AuthorizePaymentHandler.class));
//    behaviorBuilder.setCommandHandler(ConfirmPayment.class, getHandler(ConfirmPaymentHandler.class));
    return behaviorBuilder.build();
  }



}
