package com.xy;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {
    public static String jiangji_1(BlockException be) {
        System.out.println(be.getMessage());
        return "Sentinel 流控降级热点时调用的方法----111111---";
    }

    public static String jiangji_2(BlockException be) {
        System.out.println(be.getMessage());
        return "Sentinel 流控降级热点时调用的方法----222222---";
    }

}
