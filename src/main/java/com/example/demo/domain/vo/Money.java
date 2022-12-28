package com.example.demo.domain.vo;

import com.example.demo.domain.shared.ValueObject;

public class Money implements ValueObject<Money> {

  @Override
  public boolean sameValueAs(Money other) {
    return false;
  }
}
