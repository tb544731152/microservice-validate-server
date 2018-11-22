package com.zyzs.microservice.validate.config.datasources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 获取当前数据源
 * @author zk
 *
 */

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected Object determineCurrentLookupKey() {
		logger.debug("当前数据库 [{}]", DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
	}

}
