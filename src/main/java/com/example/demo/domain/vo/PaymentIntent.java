package com.example.demo.domain.vo;

public enum PaymentIntent {

  CREATED, CONFIRMED;

  public boolean isCreated() {
    return CREATED.equals(this);
  }

  public boolean isConfirmed() {
    return CONFIRMED.equals(this);
  }

}
