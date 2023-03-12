package com.consumer.controller;

import com.interfaces.bean.UserAddress;
import com.interfaces.service.ConsumerService;
import com.interfaces.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/init-Order/{id}")
    public List<UserAddress> initOrder(@PathVariable String id) throws Exception {
        return orderService.initOrder(id);
    }

    @GetMapping("/get-list")
    public List<String> getList(){
        return consumerService.getList();
    }
}
