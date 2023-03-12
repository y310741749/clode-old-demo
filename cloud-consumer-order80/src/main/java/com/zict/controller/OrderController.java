package com.zict.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zict.entity.R;
import com.zict.facade.PaymentService;
import com.zict.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController extends CommonController {
    private static final String URL = "http://localhost:8002";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private MyLoadBalancer myLoadBalancer;
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/add")
    public R add(@RequestBody JSONObject params) {
        ResponseEntity<R> mapResponseEntity = restTemplate.postForEntity(URL + "/payment/add", params, R.class);
        log.info("走80");
        mapResponseEntity.getStatusCode().is2xxSuccessful();
        return mapResponseEntity.getBody();
    }

    @GetMapping("/getOneById/{id}")
    public R getOneById(@PathVariable Long id) {
        ServiceInstance serviceInstance = myLoadBalancer.getServiceInstance(discoveryClient.getInstances("CLOUD-CONSUMER-SERVICE"));
        if (serviceInstance != null) {
            return restTemplate.getForObject(serviceInstance.getUri() + "/payment/getOneById/{id}", R.class, id);
        }
        return restTemplate.getForObject(URL + "/payment/getOneById/{id}", R.class, id);
    }

    @GetMapping("/getDisCovery")
    public R getDisCovery() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-CONSUMER-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("host:" + instance.getHost());
            System.out.println("InstanceId:" + instance.getInstanceId());
            System.out.println("ServiceId():" + instance.getServiceId());
            System.out.println("Metadata():" + instance.getMetadata());
            System.out.println("Port():" + instance.getPort());
            System.out.println("Uri:" + instance.getUri());
            System.out.println("========================");
        }
        return R.ok("service:" + services);
    }

    @GetMapping("/getOneById2/{id}")
//    @HystrixCommand(fallbackMethod = "fallBack",commandProperties={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "15000")
//    })
    @HystrixCommand
    public R getOneById2(@PathVariable Long id) {
        return paymentService.getOneById(id);
    }

    public R fallBack(Long id) {
        return R.error("80:服务器繁忙，请稍后重试");
    }
}
