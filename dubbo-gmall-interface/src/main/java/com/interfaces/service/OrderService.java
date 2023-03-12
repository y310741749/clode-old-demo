package com.interfaces.service;

import com.interfaces.bean.UserAddress;

import java.util.List;

public interface OrderService {
    /**
     * 初始化订单
     * @param userId
     */
    List<UserAddress> initOrder(String userId) throws Exception;
}
