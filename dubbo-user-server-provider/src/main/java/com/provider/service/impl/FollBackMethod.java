package com.provider.service.impl;

import com.interfaces.bean.UserAddress;

import java.util.Arrays;
import java.util.List;

public class FollBackMethod {
    List<UserAddress> hello(){
        return Arrays.asList(new UserAddress(3, "测试地址", "测试id", "测试老师", "测试电话", "Y"));
    }
}
