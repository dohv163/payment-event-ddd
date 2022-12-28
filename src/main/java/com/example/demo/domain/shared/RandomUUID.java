package com.example.demo.domain.shared;

import java.util.UUID;
import javax.validation.constraints.Size;
import org.springframework.lang.NonNull;

public abstract class RandomUUID implements ValueObject<RandomUUID>{

  @NonNull
  @Size(min = 16, max = 50)
  public final String id;

  public RandomUUID(String id) {
    this.id = String.format(getPrefix(), UUID.randomUUID().toString());
  }

  public RandomUUID() {
    this.id = String.format(getPrefix(), UUID.randomUUID().toString());
  }

  @Override
  public boolean sameValueAs(RandomUUID other) {
    return other != null && this.id.equals(other.id);
  }

  protected abstract String getPrefix();

}
