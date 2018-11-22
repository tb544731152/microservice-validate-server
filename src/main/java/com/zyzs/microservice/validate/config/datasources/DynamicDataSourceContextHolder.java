package com.zyzs.microservice.validate.config.datasources;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceContextHolder {

		private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);
		   
		private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();
	
		/**
		 * 数据源集合
		 */
		public static List<Object> dataSourceKeys = new ArrayList<Object>();
		/**
		 * 配置数据源方法
		 * @param key
		 */
		public static void setDataSourceKey(String key) {
		        CONTEXT_HOLDER.set(key);
		}
	
		/**
		 * base数据库
		 */
		public static void useBaseDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.baseDataSource.name());
		}
		/**
		 * 扫码库
		 */
		 public static void useScanDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.scanDataSource.name());
		 }
		 /**
		 * 活动库
		 */
		 public static void useActivityDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.activityDataSource.name());
		 }	 
		 /**
		 * 山东
		 */
		 public static void useSdDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.sdDataSource.name());
		 }	 
		 /**
		 * 龙江
		 */
		 public static void useHljDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.hljDataSource.name());
		 }	 		 
		 
		 /**
		 * 过渡
		 */
		 public static void useTransitionDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.transitionDataSource.name());
		 }	 
		 /**
		 * 分发
		 */
		 public static void useRouteDataSource() {
		        CONTEXT_HOLDER.set(DataSourceKey.routeDataSource.name());
		 }	 		 
	    /**
	     * 获取数据源
	     *
	     * @return data source key
	     */
	    public static String getDataSourceKey() {
	        return CONTEXT_HOLDER.get();
	    }
	    /**
	     * To set DataSource as default
	     */
	    public static void clearDataSourceKey() {
	        CONTEXT_HOLDER.remove();
	    }
	    /**
	     * Check if give DataSource is in current DataSource list
	     *
	     * @param key the key
	     * @return boolean boolean
	     */
	    public static boolean containDataSourceKey(String key) {
	        return dataSourceKeys.contains(key);
	    }
}
