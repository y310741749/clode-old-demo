package com.zict.lb.impl;

import com.zict.lb.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MyLoadBalancerImpl implements MyLoadBalancer {
    private AtomicInteger i = new AtomicInteger(0);

    private int getIndex() {
        int current;
        int next;
        do {
            current = i.get();
            next = current + 1 >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!i.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        if(CollectionUtils.isEmpty(instances)){
            return null;
        }
        return instances.get(getIndex()%instances.size());
    }
}
