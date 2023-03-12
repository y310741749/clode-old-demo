package com.xy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = FeignServiceImpl.class)
public interface FeignService {
    @GetMapping("/payment/nacos/{id}")
    public String printId(@PathVariable("id") int id);
}
