package com.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@EnableDubbo
@SpringBootApplication
//@EnableHystrix
public class OrderServiceConsumerApplication {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"static/consumer.xml"});
//        context.start();
////        OrderService orderService = context.getBean(OrderService.class);
////        orderService.initOrder("1");
//        UserService userService= (UserService) context.getBean("UserService");
//        List<UserAddress> userAddressList = userService.getUserAddressList("1");
//        userAddressList.forEach(System.out::println);
//        System.in.read();
        SpringApplication.run(OrderServiceConsumerApplication.class,args);

    }
}
