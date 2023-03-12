//package com.zict.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.zict.entity.R;
//import com.zict.service.SendMessageService;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping("/send")
//public class SendMessageController {
//    @Resource
//    SendMessageService sendMessageService;
//
//    @RequestMapping("/msg")
//    public @ResponseBody R sendMsg(@RequestBody JSONObject params){
//        sendMessageService.sendMessage(params);
//        return R.ok("");
//    }
//}
