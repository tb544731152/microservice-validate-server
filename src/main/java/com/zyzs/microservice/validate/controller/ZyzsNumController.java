package com.zyzs.microservice.validate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyzs.microservice.validate.domain.basic.ZyzsNum;
import com.zyzs.microservice.validate.domain.basic.ZyzsNumAbnormal;
import com.zyzs.microservice.validate.domain.basic.ZyzsNumBlack;
import com.zyzs.microservice.validate.service.ZsNumService;


@RestController
@RequestMapping(value="/base")
public class ZyzsNumController {
	
	@Autowired
	private ZsNumService zsNumService;
	
	/**
	 * 获取base表信息
	 * @param zsNum
	 * @return
	 */
	@GetMapping(value="/getZsNum")
	public ZyzsNum getZyzsNum(@RequestParam(value="zsNum")String zsNum){
		return zsNumService.getBaseZSNUM(zsNum);
	}
	/**
	 * 获取黑名单信息
	 * @param zsNum
	 * @return
	 */
	@GetMapping(value="/getZsNumBlack")
	public ZyzsNumBlack getZyzsNumBlack(@RequestParam(value="zsNum")String zsNum){
		return zsNumService.getBlackZsNum(zsNum);
	}
	
	/**
	 * 保存异常扫码信息
	 * @param abnormal
	 * @return
	 */
	@PostMapping("/postAbnormal")
	public Boolean post(@RequestBody ZyzsNumAbnormal abnormal) {
	    return zsNumService.saveZyzsNumAbnormal(abnormal);
	}
	
	
}
