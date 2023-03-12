package com.zict.service;

import com.zict.entity.PaymentEntity;

public interface PaymentService {
    int add(PaymentEntity paymentEntity);

    PaymentEntity getOneById(Long id);
}
