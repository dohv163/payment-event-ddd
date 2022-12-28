package com.example.demo.domain.vo;

import com.example.demo.domain.shared.RandomUUID;

public class CustomerId extends RandomUUID {

  public CustomerId(String id) {
    super(id);
  }

  @Override
  protected String getPrefix() {
    return null;
  }

}
