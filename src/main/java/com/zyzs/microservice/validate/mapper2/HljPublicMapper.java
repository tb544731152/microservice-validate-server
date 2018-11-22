package com.zyzs.microservice.validate.mapper2;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface HljPublicMapper {
	/**
	 * 黑龙江
	 * @param zsnum
	 * @return
	 */
	@Select("SELECT appid,appSecret from oo_public_num")
	public List<Map<String,Object>> hljGetAPPID();
	
	@Insert("INSERT INTO `zyzsheilongjiang`.`oo_code` (`id`, `code`, `openid`) VALUES ('1', 'hlj', '12')")
	public int insert();

	
}