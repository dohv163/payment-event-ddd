package com.example.demo.infra.persistent.mapping;

import com.example.demo.domain.vo.PaymentEventType;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"eventData", "timestamp"})
@ToString
@Entity
@Table(name = "payment-event")
public class PaymentEventTable {

  @Id
  private String eventId;
  private PaymentEventType eventType;
  private String paymentId;
  private LocalDateTime timestamp;
  @Column(length = 1024)
  private String eventData;

}
