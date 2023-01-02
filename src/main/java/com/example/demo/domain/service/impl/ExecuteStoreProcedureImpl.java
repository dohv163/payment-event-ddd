package com.example.demo.domain.service.impl;

import com.example.demo.domain.service.ExecuteStoreProcedure;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ExecuteStoreProcedureImpl implements ExecuteStoreProcedure {

    private final EntityManager entityManager;

    @Override
    public boolean createOrder(Long fid, String username, String appCode, String gatewayCode, String appTranId, Integer packageId, Long fromAmount, String fromCurrency, String orderDesc, String extraData, String clientIp, Integer sourceId) {

        Session session = null;
        try {
            session = entityManager.unwrap(Session.class);

        }catch (Exception e){

        }finally {
            if (null != session){
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean updateOrder(Long orderId, Long amount, String currency, Object paymentResult, String gatewayPaymentId, String appCode, String gatewayCode) {
        return false;
    }
}
