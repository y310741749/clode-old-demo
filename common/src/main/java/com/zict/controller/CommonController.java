package com.zict.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.zict.entity.R;
import javafx.beans.DefaultProperty;

@DefaultProperties(defaultFallback = "defaultFallBack")
public class CommonController {
    public R defaultFallBack(){
        return R.error("全局:服务器繁忙，请稍后重试");
    }
}
