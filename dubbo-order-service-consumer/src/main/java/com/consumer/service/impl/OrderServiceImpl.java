package com.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.interfaces.bean.UserAddress;
import com.interfaces.service.OrderService;
import com.interfaces.service.ProviderService;
import com.interfaces.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(check = false,version = "*")
    UserService userService;
    @Reference
    ProviderService providerService;

//    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("用户id："+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
        List<String> list = providerService.getList();
        addressList.get(0).setId(Integer.parseInt(list.get(0).toString()));
        return addressList;
    }

    public static void main(String[] args) throws Exception {
        OrderServiceImpl impl=new OrderServiceImpl();
        impl.initOrder("1");
    }
    void test(){
        System.out.println("hello");
    }

    List<UserAddress> hello(){
        return Arrays.asList(new UserAddress(3, "测试地址", "测试id", "测试老师", "测试电话", "Y"));
    }
}
