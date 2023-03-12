package com.zict.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zict.entity.PaymentEntity;
import com.zict.entity.R;
import com.zict.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController extends CommonController{
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/add")
    public R add(@RequestBody PaymentEntity paymentEntity){
        int add = paymentService.add(paymentEntity);
        return R.ok("本机port:"+port+"result:"+add);
    }

    @GetMapping("/getOneById/{id}")
//    @HystrixCommand(fallbackMethod = "fallBack",commandProperties={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "50000")
//    })
    @HystrixCommand(
            commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), //请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口日期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
            }
    )
    public R getOneById(@PathVariable Long id){
        Assert.isTrue(id>0,"id不能小于0");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int age=10/0;
        PaymentEntity oneById = paymentService.getOneById(id);
        return R.ok("线程:"+Thread.currentThread().getName()+"  本机port:"+port+" result:"+oneById);
    }

    public R fallBack(Long id){
        return R.error("服务器繁忙，请稍后重试");
    }


}
