package com.xy;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.apache.commons.lang3.ThreadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${config}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        System.out.println("config:" + config);
        return config;
    }

    @GetMapping("/config2")
    @SentinelResource(value = "config2", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "jiangji_1")
    public String getConfig2() {
//        Thread.sleep(1000);
        return "config2";
    }

    public String jiangji_1(BlockException e) {
        return "error";
    }

    @Resource
    private FeignService feignService;

    @GetMapping("/config/{id}")
    public String configId(@PathVariable("id") int id) {
        return feignService.printId(id);
    }

}
