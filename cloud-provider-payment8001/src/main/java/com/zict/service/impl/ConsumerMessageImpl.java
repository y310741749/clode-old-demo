//package com.zict.service.impl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.Message;
//
//@EnableBinding(Sink.class)
//public class ConsumerMessageImpl {
//
//    @Value("${server.port}")
//    private String port;
//
//
//    @StreamListener(Sink.INPUT)
//    void getMessage(Message<String> input){
//        System.out.println("port:"+port+"==="+input.getPayload());
//    }
//}
