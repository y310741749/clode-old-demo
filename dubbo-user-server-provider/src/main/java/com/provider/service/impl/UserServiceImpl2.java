package com.provider.service.impl;

import com.interfaces.bean.UserAddress;
import com.interfaces.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@com.alibaba.dubbo.config.annotation.Service(version = "2.0.0")
public class UserServiceImpl2 implements UserService {
	int i=0;
	@Override
	public List<UserAddress> getUserAddressList(String userId) throws Exception {
		System.out.println("调用新版本");
		i++;
		System.out.println("重试第"+i+"次");
//		if(i<=2){
//			throw new Exception("重试次数不足");
//		}
		System.out.println("UserServiceImpl.....old...");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return Arrays.asList(address1,address2).stream().filter(p->p.getId()==Integer.parseInt(userId)).collect(Collectors.toList());
	}

}
