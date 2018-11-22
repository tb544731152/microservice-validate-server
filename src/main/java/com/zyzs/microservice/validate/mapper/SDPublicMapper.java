package com.zyzs.microservice.validate.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface SDPublicMapper {
	/**
	 * 山东
	 * @param zsnum
	 * @return
	 */
	@Select("SELECT appid,appSecret from oo_public_num")
	public List<Map<String,Object>> sdGetAPPID();
	
	@Insert("INSERT INTO `zyzsshandong`.`oo_code` (`id`, `code`, `openid`) VALUES ('1', 'sd', '123')")
	public int sdinsert();
	
	
	

	
}