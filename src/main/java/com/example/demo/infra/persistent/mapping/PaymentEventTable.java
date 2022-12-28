package com.example.demo.infra.persistent.mapping;

import com.example.demo.domain.vo.PaymentEventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
