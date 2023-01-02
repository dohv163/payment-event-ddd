package com.example.demo.domain.service;

public interface ExecuteStoreProcedure {

    boolean createOrder(Long fid,
                       String username,
                       String appCode,
                       String gatewayCode,
                       String appTranId,
                       Integer packageId,
                       Long fromAmount,
                       String fromCurrency,
                       String orderDesc,
                       String extraData,
                       String clientIp,
                       Integer sourceId);

    boolean updateOrder(Long orderId,
                       Long amount,
                       String currency,
                       Object paymentResult,
                       String gatewayPaymentId,
                       String appCode,
                       String gatewayCode);

}
