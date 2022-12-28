package com.example.demo.domain.vo;

import com.example.demo.domain.shared.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Transaction implements ValueObject<Transaction> {

  @Valid
  public final Money amount;
  @NotNull
  @Size(min = 1)
  public final List<TransactionItem> items;

  @JsonCreator
  public Transaction(@JsonProperty("amount") Money amount,
      @JsonProperty("items") List<TransactionItem> items) {

    this.amount = amount;
    this.items = items;
  }

  @Override
  public boolean sameValueAs(Transaction other) {
    return false;
  }
}
