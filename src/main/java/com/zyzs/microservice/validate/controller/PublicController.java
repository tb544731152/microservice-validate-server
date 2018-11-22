package com.zyzs.microservice.validate.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zyzs.microservice.validate.domain.basic.ZyzsNum;
import com.zyzs.microservice.validate.redis.AppIdKey;
import com.zyzs.microservice.validate.redis.RedisService;
import com.zyzs.microservice.validate.redis.TokenKey;
import com.zyzs.microservice.validate.service.PublicService;
import com.zyzs.microservice.validate.service.ZsNumService;


@RestController
@RequestMapping(value="/public")
public class PublicController implements InitializingBean{
	
	@Autowired
	private PublicService publicService;
	
	@Autowired
	RedisService redisService;
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//获取appid对应的appIdsecurt
		List<Map<String,Object>> appids = publicService.getAppId();
		for(int i = 0 ; i<appids.size();i++){
			Map<String,Object> public_num = (Map<String, Object>) appids.get(i);
			String appid = public_num.get("appid").toString();
			redisService.set(AppIdKey.appid, appid, public_num);
		}
	}
	
	@GetMapping(value="/insert")
	public Boolean getZyzsNum(){
		return publicService.insert();
	}
	
	@GetMapping(value="/insert2")
	public Boolean getZyzsNum2(){
		return  publicService.insert2();
		
	}
	
	
}
