package com.zyzs.microservice.validate.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zyzs.microservice.validate.domain.basic.ZyzsNum;
import com.zyzs.microservice.validate.domain.basic.ZyzsNumAbnormal;
import com.zyzs.microservice.validate.domain.basic.ZyzsNumBlack;
@Mapper
public interface ZyzsNumMapper {
	/**
	 * base测试码10000884068352
	 * @return
	 */
	@Select("SELECT * FROM zyzs_num_${suffix} where zyzsNum=#{zsNum}")
    ZyzsNum baseGetZsnum(@Param("zsNum")String zsNum,@Param("suffix")String suffix);
	
	/**
	 * 保存异常名单
	 */
	@Insert("INSERT INTO `zyzsbase`.`zyzs_num_abnormal_${suffix}` "
			+ "(`zyzsNum`, `openId`, `ip`, `longitude`, `latitude`, `createDate`, `actionState`, `isDelete`) "
			+ "VALUES (#{abnormal.zyzsNum}, #{abnormal.openId}, #{abnormal.ip}, #{abnormal.longitude}, #{abnormal.latitude},now(),#{abnormal.actionState},'0')")
	public boolean baseSaveAbnormalZsNum(@Param("abnormal")ZyzsNumAbnormal abnormal,@Param("suffix")String suffix);
	
	
	/**
	 * 查询黑名单
	 * @param zsnum
	 * @return
	 */
	@Select("SELECT * from zyzs_num_black WHERE zyzsNum=#{zsnum}")
	public ZyzsNumBlack baseGetBlackZsNum(@Param("zsnum")String zsnum);

	
}