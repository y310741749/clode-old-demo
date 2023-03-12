package com.zict.facade;

import com.zict.entity.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cloud-consumer-service")
@Component
public interface PaymentService {
    @GetMapping("/payment/getOneById/{id}")
    public R getOneById(@PathVariable("id") Long id);
}
