package com.example.demo.domain.vo;

import com.example.demo.domain.shared.RandomUUID;

public class PaymentId extends RandomUUID {

  public PaymentId() {
    super();
  }

  public PaymentId(String id) {
    super(id);
  }

  @Override
  protected String getPrefix() {
    return "PAY-%s";
  }

}
