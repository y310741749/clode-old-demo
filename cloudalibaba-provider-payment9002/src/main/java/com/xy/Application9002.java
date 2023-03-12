package com.xy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class Application9002 {
    public static void main(String[] args) {
        SpringApplication.run(Application9002.class,args);
    }

    @Value("${server.port}")
    int port;
    @GetMapping("/test")
    public void test(){
        System.out.println("test...");
    }

    @GetMapping("/payment/nacos/{id}")
    public String printId(@PathVariable int id){
        return "请求端口:"+port+" id:"+id;
    }

    @GetMapping("/consumer")
    public String consumer(){
        return port+"";
    }
}
