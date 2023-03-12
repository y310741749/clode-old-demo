package com.zict.service.impl;

import com.zict.dao.PaymentDao;
import com.zict.entity.PaymentEntity;
import com.zict.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int add(PaymentEntity paymentEntity) {
        return  paymentDao.add(paymentEntity);
    }

    @Override
    public PaymentEntity getOneById(Long id) {
        return paymentDao.getOneById(id);
    }
}
