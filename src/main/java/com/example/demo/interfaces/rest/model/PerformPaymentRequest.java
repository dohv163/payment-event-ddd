package com.example.demo.interfaces.rest.model;

import com.example.demo.domain.vo.PaymentIntent;
import com.example.demo.domain.vo.PaymentMethod;
import com.example.demo.domain.vo.Transaction;
import com.example.demo.infra.util.validation.ValidEnum;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class PerformPaymentRequest {
    @NotNull
    private String customerId;
    @ValidEnum(conformsTo = PaymentIntent.class)
    private String paymentIntent;
    @ValidEnum(conformsTo = PaymentMethod.class)
    private String paymentMethod;
    @Valid
    private Transaction transaction;
}
