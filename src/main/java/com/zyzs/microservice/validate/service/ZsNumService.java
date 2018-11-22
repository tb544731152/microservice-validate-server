package com.zyzs.microservice.validate.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyzs.microservice.validate.domain.basic.ZyzsNum;
import com.zyzs.microservice.validate.domain.basic.ZyzsNumAbnormal;
import com.zyzs.microservice.validate.domain.basic.ZyzsNumBlack;
import com.zyzs.microservice.validate.mapper.ZyzsNumMapper;

@Service
@Transactional
public class ZsNumService {

	@Autowired
	ZyzsNumMapper zyzsNumMapper;

	public ZyzsNum getBaseZSNUM(String  zsnum) {
		String tableSuffix = getBaseSuffix(zsnum);
		zsnum = zsnum.substring(8,zsnum.length());
		return zyzsNumMapper.baseGetZsnum(zsnum,tableSuffix);
	}

	
	public boolean saveZyzsNumAbnormal(ZyzsNumAbnormal abnormal) {
		return  zyzsNumMapper.baseSaveAbnormalZsNum(abnormal, getDateSuffix());
	}
	
	public ZyzsNumBlack getBlackZsNum(String zsNum){
		return zyzsNumMapper.baseGetBlackZsNum(zsNum);
	}
	
	/**
	 * 按月分表--获取表后缀
	 * @return
	 */
	public String getDateSuffix(){
		Calendar cale = Calendar.getInstance(); 
		int year = cale.get(Calendar.YEAR);  
	    int month = cale.get(Calendar.MONTH) + 1; 
	    return year+"_"+month;
	}
	
	/**
	 * 获取base 表后缀
	 */
	public String getBaseSuffix(String zsNum){
		String product = zsNum.substring(0, 6);
		String batch = zsNum.substring(6, 8);
		String tableSuffix = product+"_"+batch;
		return tableSuffix;
	}
}
