package com.zict.dao;

import com.zict.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int add(PaymentEntity paymentEntity);

    PaymentEntity getOneById(@Param("id") Long id);

}
