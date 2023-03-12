package com.zict.entity;

import java.util.HashMap;

public class R extends HashMap {
    public static R ok(Object data){
        R r =new R();
        r.put("code",200);
        r.put("msg","成功");
        r.put("data",data);
        return r;
    }

    public static R error(Object data){
        R r =new R();
        r.put("code",999);
        r.put("msg","失败");
        r.put("data",data);
        return r;
    }
}
