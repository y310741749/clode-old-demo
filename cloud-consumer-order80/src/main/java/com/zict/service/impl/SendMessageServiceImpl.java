//package com.zict.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.zict.service.SendMessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.integration.support.MessageBuilder;
//
////@EnableBinding(Source.class)
//public class SendMessageServiceImpl implements SendMessageService {
//
//    @Autowired
//    private Source source;
//    @Override
//    public void sendMessage(JSONObject params) {
//        source.output().send(MessageBuilder.withPayload(params).build());
//    }
//}
