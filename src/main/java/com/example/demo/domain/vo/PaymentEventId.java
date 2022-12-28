package com.example.demo.domain.vo;

import com.example.demo.domain.shared.RandomUUID;

public class PaymentEventId extends RandomUUID {

  public PaymentEventId() {
    super(id);
  }

  @Override
  protected String getPrefix() {
    return "PEV-%s";
  }
}
