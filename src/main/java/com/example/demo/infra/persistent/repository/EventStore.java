package com.example.demo.infra.persistent.repository;

import com.example.demo.infra.persistent.mapping.PaymentEventTable;
import org.springframework.data.repository.CrudRepository;

public interface EventStore extends CrudRepository<PaymentEventTable, String> {

}
