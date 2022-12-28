package com.example.demo.infra.persistent.repository;

import com.example.demo.domain.entity.PaymentEventRepository;
import com.example.demo.domain.event.PaymentEvent;
import com.example.demo.domain.vo.PaymentEventId;
import com.example.demo.infra.persistent.mapping.PaymentEventTable;
import com.example.demo.infra.util.json.JsonMapper;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PaymentEventRepositoryImpl implements PaymentEventRepository {

  private final EventStore eventStore;
  private final JsonMapper jsonMapper;

  PaymentEventRepositoryImpl(EventStore eventStore,JsonMapper jsonMapper) {
    this.eventStore = eventStore;
    this.jsonMapper = jsonMapper;
  }

  @Override
  public CompletionStage<PaymentEventId> store(PaymentEvent paymentEvent) {
    log.info("Storing paymentEvent {}", paymentEvent);
    String eventDataAsJson = jsonMapper.write(paymentEvent);
    log.info("eventDataAsJson {}", eventDataAsJson);
    PaymentEventTable paymentEventTable = new PaymentEventTable();
    paymentEventTable.setEventId(paymentEvent.getEventId().id);
    paymentEventTable.setEventType(paymentEvent.getEventType());
    paymentEventTable.setPaymentId(paymentEvent.getPaymentId().id);
    paymentEventTable.setTimestamp(paymentEvent.getTimestamp());
    paymentEventTable.setEventData(eventDataAsJson);
    eventStore.save(paymentEventTable);
    return CompletableFuture.completedFuture(paymentEvent.getEventId());
  }
}
