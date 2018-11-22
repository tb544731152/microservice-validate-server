package com.zyzs.microservice.validate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.zyzs.microservice.validate.mapper.SDPublicMapper;
import com.zyzs.microservice.validate.mapper2.HljPublicMapper;

@Service
@Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
public class PublicService {

	@Autowired
	SDPublicMapper SDMapper;
	@Autowired
	HljPublicMapper  hljMapper;
	
	
	public List<Map<String,Object>> getAppId() {
		List<Map<String,Object>> hljappIds =hljMapper.hljGetAPPID(); 
		List<Map<String,Object>> sdappIds = SDMapper.sdGetAPPID();
		
		for (int i = 0; i < hljappIds.size(); i++) {
			sdappIds.add(hljappIds.get(i));
		}
		return sdappIds;
	}
	
	public Boolean insert() {
		SDMapper.sdinsert();
		int i = SDMapper.sdinsert();
		return i>0;
		
	}
	public Boolean insert2() {
		SDMapper.sdinsert();
		hljMapper.insert();
		int i = 1/0;
		return null;
		
	}
}
