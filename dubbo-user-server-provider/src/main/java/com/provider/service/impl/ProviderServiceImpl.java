package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.interfaces.service.ProviderService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public List<String> getList() {
        return Stream.of("1","2","3").collect(Collectors.toList());
    }
}
