package com.zict.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalancer {
    ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
