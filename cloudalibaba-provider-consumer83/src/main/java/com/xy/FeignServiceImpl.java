package com.xy;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String printId(int id) {
        return "进入feignFallBack";
    }
}
