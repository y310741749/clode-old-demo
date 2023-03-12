package com.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.interfaces.service.ConsumerService;
import com.interfaces.service.ProviderService;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Reference
    private ProviderService providerService;
    @Override
    public List<String> getList() {
        return providerService.getList();

    }
}
