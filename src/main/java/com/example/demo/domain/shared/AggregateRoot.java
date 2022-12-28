package com.example.demo.domain.shared;

import java.io.Serializable;

public abstract class AggregateRoot <E, ID extends Serializable> implements Entity<E, ID>{


  protected abstract AggregateRootBehavior initialBehavior();

  public class AggregateRootBehavior<ID> {

  }

}
