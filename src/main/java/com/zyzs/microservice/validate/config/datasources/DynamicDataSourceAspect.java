package com.zyzs.microservice.validate.config.datasources;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 数据库动态切换
 * @author zk
 *
 */
public class DynamicDataSourceAspect{
	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
	private final String[] QUERY_PREFIX = {"base","scan","activity","sd","hlj","transition","route"};
	/**
     * dao 切面
     */
    @Pointcut("execution( * com.zyzs.microservice.validate.mapper.*.*(..))")
    public void daoAspect() {
    }

    /**
     * 切换数据源
     * @param point the point
     */
    @Before("daoAspect()")
    public void switchDataSource(JoinPoint point) {
        String isQueryMethod = isQueryMethod(point.getSignature().getName());
        logger.info("查询方法："+isQueryMethod);
        if (isQueryMethod.equals("scan")) {
            DynamicDataSourceContextHolder.useScanDataSource();
        }else if(isQueryMethod.equals("activity")){
        	DynamicDataSourceContextHolder.useActivityDataSource();
        }
        else if(isQueryMethod.equals("route")){
        	DynamicDataSourceContextHolder.useRouteDataSource();
        }
        else if(isQueryMethod.equals("sd")){
        	DynamicDataSourceContextHolder.useSdDataSource();
        }
        else if(isQueryMethod.equals("hlj")){
        	DynamicDataSourceContextHolder.useHljDataSource();
        }else if(isQueryMethod.equals("transition")){
        	DynamicDataSourceContextHolder.useTransitionDataSource();
        }else{
        	DynamicDataSourceContextHolder.useBaseDataSource();
        }
    }

	private String isQueryMethod(String name) {
		 for (String prefix : QUERY_PREFIX) {
	           if (name.startsWith(prefix)) {
	                return prefix;
	           }
	        }
	     return "base";
	}
	

}
