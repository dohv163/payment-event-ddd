package com.example.demo.domain.shared;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;

public abstract class AggregateRoot <E, ID extends Serializable> implements Entity<E, ID>{

  public final ID entityId;
  private final ApplicationContext applicationContext;
  private AggregateRootBehavior behavior;

  protected AggregateRoot(ApplicationContext applicationContext, ID entityId) {
    this.entityId = entityId;
    this.applicationContext = applicationContext;
    this.behavior = initialBehavior();
  }

  protected abstract AggregateRootBehavior initialBehavior();

  public class AggregateRootBehavior<ID> {

    protected final Map<Class<? extends Command>, CommandHandler<? extends Command, ? extends Event, ID>> handlers;

    public AggregateRootBehavior(Map<Class<? extends Command>, CommandHandler<? extends Command, ? extends Event, ID>> handlers) {
      this.handlers = Collections.unmodifiableMap(handlers);
    }

    protected <A extends Command, B extends Event> CommandHandler<A, B, ID> getHandler(Class<? extends CommandHandler> commandHandlerClass) {
      return applicationContext.getBean(commandHandlerClass);
    }

    public class AggregateRootBehaviorBuilder<ID> {

      private final Map<Class<? extends Command>, CommandHandler<? extends Command, ? extends Event, ID>> handlers = new HashMap<>();

      public <A extends Command, B extends Event> AggregateRootBehaviorBuilder setCommandHandler(Class<A> commandClass, CommandHandler<A, B, ID> handler) {
        handlers.put(commandClass, handler);
        return this;
      }

      public AggregateRootBehavior build() {
        return new AggregateRootBehavior(handlers);
      }
    }

  }

}
