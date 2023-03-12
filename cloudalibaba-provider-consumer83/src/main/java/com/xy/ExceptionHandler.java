package com.xy;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionHandler {
    public static String dealConfig(BlockException e){
        return "errors";
    }
}
