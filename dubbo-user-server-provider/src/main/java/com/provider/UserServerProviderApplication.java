package com.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@EnableDubbo
@SpringBootApplication
//@EnableHystrix
public class UserServerProviderApplication {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext ioc=new ClassPathXmlApplicationContext(new String[]{"static/provider.xml"});
//        ioc.start();
//        System.in.read();
        SpringApplication.run(UserServerProviderApplication.class,args);
    }



}
