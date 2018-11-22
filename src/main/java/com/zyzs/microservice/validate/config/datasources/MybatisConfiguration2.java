package com.zyzs.microservice.validate.config.datasources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({ DataBaseConfiguration.class})
@MapperScan(basePackages="com.zyzs.microservice.validate.mapper2",sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisConfiguration2 {
 
 
	    
	 @Resource(name = "hljDataSource")
	 private DataSource hljDataSource;
	    
    
    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(hljDataSource);
        factoryBean.setTypeAliasesPackage("com.zyzs.microservice.validate.domain");
        //指定mapper xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:com/zyzs/microservice/validate/mapper2/*.xml"));
        factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2()); // 使用上面配置的Factory
        return template;
    }
    
   /* *//**
     * 有多少个数据源就要配置多少个bean
     * @return
     *//*
    @Bean
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
    	DynamicRoutingDataSource proxy = new DynamicRoutingDataSource();
    	Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
    	targetDataSources.put(DataSourceKey.sdDataSource.name(), sdDataSource);
    	targetDataSources.put(DataSourceKey.hljDataSource.name(), hljDataSource);
    	proxy.setDefaultTargetDataSource(sdDataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }*/
    
}
